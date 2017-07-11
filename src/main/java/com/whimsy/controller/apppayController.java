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
        //ʵ�����ͻ���
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", AlipayConfig.app_id, AlipayConfig.private_key , "json", AlipayConfig.input_charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //ʵ��������API��Ӧ��request��,�����ƺͽӿ����ƶ�Ӧ,��ǰ���ýӿ����ƣ�alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK�Ѿ���װ���˹�������������ֻ��Ҫ����ҵ����������·���Ϊsdk��model��η�ʽ(model��biz_contentͬʱ���ڵ������ȡbiz_content)��
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setPassbackParams(URLEncoder.encode(body.toString()));;  //������Ϣ  ��Ӹ�������
        model.setSubject("�ȸ�"); //��Ʒ����
        model.setOutTradeNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+(int)(Math.random()*90000+10000)); //�̼Ҷ������
        model.setTimeoutExpress("30m"); //��ʱ�رոö���ʱ��
        model.setTotalAmount(amount);  //�����ܽ��
        model.setProductCode("QUICK_MSECURITY_PAY"); //���۲�Ʒ�룬�̼Һ�֧����ǩԼ�Ĳ�Ʒ�룬Ϊ�̶�ֵQUICK_MSECURITY_PAY
        request.setBizModel(model);
        request.setNotifyUrl(AlipayConfig.service);  //�ص���ַ
        String orderStr = "";
        try {
        	//�������ͨ�Ľӿڵ��ò�ͬ��ʹ�õ���sdkExecute
        	AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
        	orderStr = response.getBody();
        	System.out.println(orderStr);//����orderString ����ֱ�Ӹ��ͻ�������������������
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
        System.out.println("֧����֧�����֪ͨ"+requestParams.toString());
        //��ȡ֧����POST����������Ϣ
        Map<String,String> params = new HashMap<String,String>();
        
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
            	valueStr = (i == values.length - 1) ? valueStr + values[i]
                		: valueStr + values[i] + ",";
            }
            //����������δ����ڳ�������ʱʹ�á�
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //�м�alipaypublickey��֧�����Ĺ�Կ����ȥopen.alipay.com��ӦӦ���²鿴��
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        try {
        	//��֤ǩ��
            boolean flag = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.input_charset, "RSA2");
            if(flag){
                if("TRADE_SUCCESS".equals(params.get("trade_status"))){
                    //������
                    String amount = params.get("buyer_pay_amount");
                    //�̻�������
                    String out_trade_no = params.get("out_trade_no");
                    //֧�������׺�
                    String trade_no = params.get("trade_no");
                    //��������
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
    						//�޸�ʣ����֡����
    						tMemberCard.setJid(ord.getjMembercardId());
    						//��ѯʣ�������
    						TMemberCard num = this.memberService.getInte(ord.getjMembercardId());
    						//��ѯ�������һ�RMB��
    						TDepartment getScore = this.tdService.selectScore(ord.getjDeptId());
    						BigDecimal aaa = new BigDecimal(BigdecimalUtil.mul(ord.getjIfscore().doubleValue(),getScore.getJscoreforrmb().doubleValue()));
    						tMemberCard.setJendqty(new BigDecimal(BigdecimalUtil.sub(num.getJendqty().doubleValue(),aaa.doubleValue())));
    						tMemberCard.setJoutfillamt(new BigDecimal(BigdecimalUtil.sub(num.getJoutfillamt().doubleValue(),ord.getjIfmembercard().doubleValue())));
    						int out = this.memberService.updateall(tMemberCard);
    						System.out.println(out);
    					}
    					System.out.println("�޸ĳɹ�");
    				}else{
    					System.out.println("�޸�ʧ��");
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

        // ��������
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
                strResponse="�˿�ɹ�";
            }else {
                strResponse=response.getSubMsg();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass()).error("alipayRefundRequest", e);
        }
        return strResponse;

    }*/
}
