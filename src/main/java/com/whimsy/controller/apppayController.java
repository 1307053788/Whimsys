package com.whimsy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.google.gson.Gson;
import com.whimsy.entity.TDepartment;
import com.whimsy.entity.TMemberCard;
import com.whimsy.entity.TOrderDetailed;
import com.whimsy.service.TDepartmentService;
import com.whimsy.service.TMemberCardService;
import com.whimsy.service.TOrderDetailedService;
import com.whimsy.util.AlipayConfig;
import com.whimsy.util.BigdecimalUtil;
import com.whimsy.util.DateUtil;

import net.sf.json.JSONObject;

@Controller
public class apppayController {
	
	@Autowired
	private TOrderDetailedService orderService;
	
	@Autowired
	private TMemberCardService memberService;
	
	@Autowired
	private TDepartmentService tdService;
	
	@ResponseBody
	@RequestMapping(value = "zhifubao/alipay",  produces = "text/html;charset=UTF-8",method={RequestMethod.GET})
	public void aliPay(Map<String,Object> body,HttpServletResponse responses) throws IOException{
		PrintWriter pw = null;
		pw = responses.getWriter();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		String amount = "0.01";
        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", AlipayConfig.app_id, AlipayConfig.private_key , "json", AlipayConfig.input_charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setPassbackParams(URLEncoder.encode(body.toString()));;  //描述信息  添加附加数据
        model.setSubject("魅格"); //商品标题
        model.setOutTradeNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+(int)(Math.random()*90000+10000)); //商家订单编号
        model.setTimeoutExpress("30m"); //超时关闭该订单时间
        model.setTotalAmount(amount);  //订单总金额
        model.setProductCode("QUICK_MSECURITY_PAY"); //销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
        request.setBizModel(model);
        request.setNotifyUrl(AlipayConfig.service);  //回调地址
        String orderStr = "";
        try {
        	//这里和普通的接口调用不同，使用的是sdkExecute
        	AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
        	orderStr = response.getBody();
        	System.out.println(orderStr);//就是orderString 可以直接给客户端请求，无需再做处理。
        	result.put("info", orderStr);
	        result.put("type", 2);
        	resultMap.put("data", result);
			resultMap.put("code", "100000");
			resultMap.put("message", "success");
        } catch (AlipayApiException e) {
        	e.printStackTrace();
        } finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
        /*return RetKit.okData(orderStr);*/
    }
	@ResponseBody
	@RequestMapping(value = "zhifubao/callbacks",  produces = "text/html;charset=UTF-8",method={RequestMethod.GET})
	public String aliPay_notify(Map requestParams,TOrderDetailed tOrderDetailed,TMemberCard tMemberCard){
        System.out.println("支付宝支付结果通知"+requestParams.toString());
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
            	valueStr = (i == values.length - 1) ? valueStr + values[i]
                		: valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        try {
        	//验证签名
            boolean flag = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.input_charset, "RSA2");
            if(flag){
                if("TRADE_SUCCESS".equals(params.get("trade_status"))){
                    //付款金额
                    String amount = params.get("buyer_pay_amount");
                    //商户订单号
                    String out_trade_no = params.get("out_trade_no");
                    //支付宝交易号
                    String trade_no = params.get("trade_no");
                    //附加数据
                    String passback_params = URLDecoder.decode(params.get("passback_params"));
                    
                    tOrderDetailed.setjOrdercode(out_trade_no);
    	            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    				String data = df.format(new Date()).toString();
    				Date paytime = df.parse(data);
    				tOrderDetailed.setjPaytime(paytime);
    				tOrderDetailed.setjUptime(paytime);
    				tOrderDetailed.setjState("3");
    				int order = this.orderService.uporderstate(tOrderDetailed);
    				if(order == 1){
    					TOrderDetailed ord = this.orderService.getOrder(out_trade_no);
    					if(ord != null){
    						//修改剩余积分、余额
    						tMemberCard.setJid(ord.getjMembercardId());
    						//查询剩余积分数
    						TMemberCard num = this.memberService.getInte(ord.getjMembercardId());
    						//查询积分数兑换RMB数
    						TDepartment getScore = this.tdService.selectScore(ord.getjDeptId());
    						BigDecimal aaa = new BigDecimal(BigdecimalUtil.mul(ord.getjIfscore().doubleValue(),getScore.getJscoreforrmb().doubleValue()));
    						tMemberCard.setJendqty(new BigDecimal(BigdecimalUtil.sub(num.getJendqty().doubleValue(),aaa.doubleValue())));
    						tMemberCard.setJoutfillamt(new BigDecimal(BigdecimalUtil.sub(num.getJoutfillamt().doubleValue(),ord.getjIfmembercard().doubleValue())));
    						int out = this.memberService.updateall(tMemberCard);
    						System.out.println(out);
    					}
    					System.out.println("修改成功");
    				}else{
    					System.out.println("修改失败");
    				}
                }
            }
        } catch (AlipayApiException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	return "success";
    }
	/*@ResponseBody
	@RequestMapping(value = "zhifubao/refund",  produces = "text/html;charset=UTF-8",method={RequestMethod.GET})
	public String alipayRefundRequest(String out_trade_no,String trade_no,double refund_amount){

        // 发送请求
        String strResponse = null;
        try {
            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",AlipayConfig.app_id,
                            AlipayConfig.private_key,AlipayConfig.sign_type,AlipayConfig.input_charset,AlipayConfig.alipay_public_key);
            AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
            AlipayRefundInfo alidata= new AlipayRefundInfo();
            alidata.setOut_trade_no(out_trade_no);
            alidata.setRefund_amount(refund_amount);
            alidata.setTrade_no(trade_no);
            request.setBizContent(JsonUtils.convertToString(alidata));
            AlipayTradeRefundResponse response = alipayClient.execute(request);
            strResponse=response.getCode();
            if ("10000".equals(response.getCode())) {
                strResponse="退款成功";
            }else {
                strResponse=response.getSubMsg();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass()).error("alipayRefundRequest", e);
        }
        return strResponse;

    }*/
}
