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
import com.whimsy.entity.TCouponDetailed;
import com.whimsy.entity.TDepartment;
import com.whimsy.entity.TMemberCard;
import com.whimsy.entity.TOrderDetailed;
import com.whimsy.service.TCouponDetailedService;
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
	
	@Autowired
	private TCouponDetailedService tcdService;
	
	@ResponseBody
	@RequestMapping(value = "zhifubao/alipay",  produces = "text/html;charset=UTF-8",method={RequestMethod.GET})
	public void aliPay(HttpServletRequest reques,Map<String,Object> body,HttpServletResponse responses) throws IOException{
		PrintWriter pw = null;
		pw = responses.getWriter();
		String trade_no = reques.getParameter("jordercode");
		String sym = reques.getRequestURL().toString().split("/zhifubao/")[0];
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		String amount = reques.getParameter("jmoney");
        //ʵ�����ͻ���
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", AlipayConfig.app_id, AlipayConfig.private_key , "json", AlipayConfig.input_charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //ʵ��������API��Ӧ��request��,�����ƺͽӿ����ƶ�Ӧ,��ǰ���ýӿ����ƣ�alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK�Ѿ���װ���˹�������������ֻ��Ҫ����ҵ����������·���Ϊsdk��model��η�ʽ(model��biz_contentͬʱ���ڵ������ȡbiz_content)��
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setPassbackParams(URLEncoder.encode(body.toString()));;  //������Ϣ  ��Ӹ�������
        model.setSubject("��������"); //��Ʒ����
        model.setOutTradeNo(trade_no); //�̼Ҷ������
        model.setTimeoutExpress("30m"); //��ʱ�رոö���ʱ��
        model.setTotalAmount(amount);  //�����ܽ��
        model.setProductCode("QUICK_MSECURITY_PAY"); //���۲�Ʒ�룬�̼Һ�֧����ǩԼ�Ĳ�Ʒ�룬Ϊ�̶�ֵQUICK_MSECURITY_PAY
        request.setBizModel(model);
        request.setNotifyUrl(sym + AlipayConfig.service);  //�ص���ַ
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
	@ResponseBody
	@RequestMapping(value = "zhifubao/refund",  produces = "text/html;charset=UTF-8",method={RequestMethod.GET})
	public void alipayRefundRequest(HttpServletRequest request, HttpServletResponse response,TCouponDetailed tCouponDetailed,TMemberCard tMemberCard){
		PrintWriter pw = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		String trade_no = request.getParameter("jordercode");
		System.out.println();
		TOrderDetailed ord = this.orderService.getOrder(trade_no);
        // ��������
        String strResponse = null;
        try {
        	pw = response.getWriter();
            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",AlipayConfig.app_id,AlipayConfig.private_key,"json",AlipayConfig.input_charset,AlipayConfig.alipay_public_key,AlipayConfig.sign_type);
            AlipayTradeRefundRequest reques = new AlipayTradeRefundRequest();
            reques.setBizContent("{" +
            		"\"out_trade_no\":\""+ trade_no+"\"," +
            		"\"refund_amount\":\""+ord.getjMoney()+"\""+
            		"  }");
            AlipayTradeRefundResponse respons = alipayClient.execute(reques);
            strResponse=respons.getCode();
            if ("10000".equals(respons.getCode())) {
                strResponse="�˿�ɹ�";
                System.out.println(strResponse);
                if(ord.getjCopId()>0){
                	//�޸��Ż�ȯ״̬
					tCouponDetailed.setjId(ord.getjCopId());
					tCouponDetailed.setjState("1");
					this.tcdService.upcoup(tCouponDetailed);
                }
                if(ord.getjIfscore().compareTo(new BigDecimal(0))==1){
                	//�޸�ʣ����֡����
					tMemberCard.setJid(ord.getjMembercardId());
					//��ѯʣ�������
					TMemberCard num = this.memberService.getInte(ord.getjMembercardId());
					//��ѯ�������һ�RMB��
					TDepartment getScore = this.tdService.selectScore(ord.getjDeptId());
					BigDecimal aaa = new BigDecimal(BigdecimalUtil.mul(ord.getjIfscore().doubleValue(),getScore.getJscoreforrmb().doubleValue()));
					tMemberCard.setJendqty(new BigDecimal(BigdecimalUtil.add(num.getJendqty().doubleValue(),aaa.doubleValue())));
					tMemberCard.setJoutfillamt(new BigDecimal(BigdecimalUtil.add(num.getJoutfillamt().doubleValue(),ord.getjIfmembercard().doubleValue())));
					int out = this.memberService.updateall(tMemberCard);
					if(out==1){
						resultMap.put("data", out);
						resultMap.put("code", "100000");
						resultMap.put("message", "success");
					}else{
						resultMap.put("data", out);
						resultMap.put("code", "100002");
						resultMap.put("message", "�˿�ʧ�ܣ�");
					}
                }
            }else {
                strResponse=respons.getSubMsg();
                System.out.println(strResponse);
                resultMap.put("data", "");
				resultMap.put("code", "100002");
				resultMap.put("message", "�˿�ʧ��,�Ժ����ԣ�");
            }
        } catch (Exception e) {
            Logger.getLogger(getClass()).error("alipayRefundRequest", e);
        } finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
    }
}
