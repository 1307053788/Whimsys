package com.whimsy.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.whimsy.entity.TCouponDetailed;
import com.whimsy.entity.TDepartment;
import com.whimsy.entity.TMemberCard;
import com.whimsy.entity.TOrderDetailed;
import com.whimsy.service.TCouponDetailedService;
import com.whimsy.service.TDepartmentService;
import com.whimsy.service.TMemberCardService;
import com.whimsy.service.TOrderDetailedService;
import com.whimsy.util.BigdecimalUtil;
import com.whimsy.util.PayCommonUtil;

@Controller
@RequestMapping(value = "/api")
public class WeiXinPayController {
	
	@Autowired
	private TOrderDetailedService orderService;
	
	@Autowired
	private TMemberCardService memberService;
	
	@Autowired
	private TDepartmentService tdService;
	
	@Autowired
	private TCouponDetailedService tcdService;
	
    protected static Logger logger = Logger.getLogger(WeiXinPayController.class);
    
    String timeMillis = String.valueOf(System.currentTimeMillis() / 1000);
    String randomString = PayCommonUtil.getRandomString(32);
    public static String wxnotify = "/api/json/money/wxpay/succ";
    
    /**
     * @param totalAmount    支付金额
     * @param description    描述
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "weixin/weixinPay",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SortedMap<String, Object> ToPay(HttpServletRequest request, HttpServletResponse response) {
    	PrintWriter pw = null;
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	Map<String, Object> result = new HashMap<String, Object>();
    	try {
			pw = response.getWriter();
			String sym = request.getRequestURL().toString().split("/api/")[0];
	        BigDecimal totalAmount = new BigDecimal(0.01/*request.getParameter("jmoney")*/);
	        String description = "鲸哥鲜生-商品购买" /*request.getParameter("description")*/;
	        String trade_no = request.getParameter("jordercode");
	        Map<String, String> map = weixinPrePay(trade_no,totalAmount,description,sym,request);  
	        
	        SortedMap<String, Object> finalpackage = new TreeMap<String, Object>();
	        finalpackage.put("appid", PayCommonUtil.APPID);
	        finalpackage.put("partnerid", PayCommonUtil.MCH_ID);
	        finalpackage.put("prepayid", map.get("prepay_id"));
	        finalpackage.put("package", "Sign=WXPay");
	        finalpackage.put("noncestr", PayCommonUtil.getRandomString(32));  
	        finalpackage.put("timestamp", timeMillis);  
	        String sign = PayCommonUtil.createSign("UTF-8", finalpackage);  
	        finalpackage.put("sign",sign);
	        result.put("info", finalpackage);
	        result.put("type", 1);
	        resultMap.put("data", result);
			resultMap.put("code", "100000");
			resultMap.put("message", "seccess");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
        return null;
    } 
    
    @SuppressWarnings("unchecked")
    public Map<String, String> weixinPrePay(String trade_no,BigDecimal totalAmount,  
            String description,String sym, HttpServletRequest request) { 
        SortedMap<String, Object> parameterMap = new TreeMap<String, Object>();  
        parameterMap.put("appid", PayCommonUtil.APPID);  
        parameterMap.put("body", description);
        parameterMap.put("mch_id", PayCommonUtil.MCH_ID);  
        parameterMap.put("nonce_str", randomString);  
        parameterMap.put("notify_url", sym + wxnotify);
        parameterMap.put("out_trade_no", trade_no);
        parameterMap.put("spbill_create_ip", "123.12.12.123");  
        BigDecimal total = totalAmount.multiply(new BigDecimal(100));  
        java.text.DecimalFormat df=new java.text.DecimalFormat("0");  
        parameterMap.put("total_fee", df.format(total));  
        parameterMap.put("trade_type", "APP");
        /*parameterMap.put("fee_type", "CNY");  */
        /*parameterMap.put("trade_type", "JSAPI");*/
        //trade_type为JSAPI是 openid为必填项
        /*parameterMap.put("openid", openid);*/
        String sign = PayCommonUtil.createSign("UTF-8", parameterMap); 
        parameterMap.put("sign", sign);
        String requestXML = com.whimsy.util.PayCommonUtil.getRequestXml(parameterMap);  
        String result = PayCommonUtil.httpsRequest("https://api.mch.weixin.qq.com/pay/unifiedorder","POST",requestXML);
        Map<String, String> map = null;  
        try {  
            map = PayCommonUtil.doXMLParse(result);  
        } catch (JDOMException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        System.out.println("map="+map);
        return map;        
    }
    //退款
    @ResponseBody
    @RequestMapping(value = "weixin/wxRefund",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void wxRefund(HttpServletRequest request, HttpServletResponse response,TCouponDetailed tCouponDetailed,TOrderDetailed tOrderDetailed,TMemberCard tMemberCard) throws JDOMException { 
    	PrintWriter pw = null;
    	String jordercode = request.getParameter("jordercode");
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	Map<String, Object> result = new HashMap<String, Object>();
    	try {
			pw = response.getWriter();
			TOrderDetailed ord = this.orderService.getOrder(jordercode);
			SortedMap<String, Object> parameterMap = new TreeMap<String, Object>(); 
	        parameterMap.put("appid", PayCommonUtil.APPID);  
	        parameterMap.put("mch_id", PayCommonUtil.MCH_ID);  
	        parameterMap.put("nonce_str", randomString);  
	        parameterMap.put("out_trade_no", jordercode);
	        parameterMap.put("out_refund_no", jordercode);
	        BigDecimal total = ord.getjMoney().multiply(new BigDecimal(100));  
	        java.text.DecimalFormat df=new java.text.DecimalFormat("0");  
	        parameterMap.put("total_fee", "1");  
	        parameterMap.put("refund_fee", "1");  
	        String sign = PayCommonUtil.createSign("UTF-8", parameterMap); 
	        parameterMap.put("sign", sign);
	        String requestXML = com.whimsy.util.PayCommonUtil.getRequestXml(parameterMap);  
	        System.out.println("nnnnn=" + requestXML);
	        String resul = PayCommonUtil.httpsRequest2("https://api.mch.weixin.qq.com/secapi/pay/refund","POST",requestXML);
	        Map<String, String> map = null; 
	        System.out.println("tttttt"+resul);
	        resultMap.put("data", resul);
			resultMap.put("code", "100000");
			resultMap.put("message", "seccess");
	        try {  
	            map = PayCommonUtil.doXMLParse(resul);
	            System.out.println("map="+map);
	            if(map.get("result_code").equals("SUCCESS")){
	            	tOrderDetailed.setjOrdercode(jordercode.toString());
		            SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
					String data = dfs.format(new Date()).toString();
					Date paytime = dfs.parse(data);
					tOrderDetailed.setjEndtime(paytime);
					tOrderDetailed.setjUptime(paytime);
					tOrderDetailed.setjState("6");
					//修改订单状态
					int order = this.orderService.uporderstate(tOrderDetailed);
					System.out.println(order);
	            	if(ord.getjCopId()>0){
	                	//修改优惠券状态
						tCouponDetailed.setjId(ord.getjCopId());
						tCouponDetailed.setjState("1");
						this.tcdService.upcoup(tCouponDetailed);
	                }
	                if(ord.getjIfscore().compareTo(new BigDecimal(0))==1){
	                	//修改剩余积分、余额
						tMemberCard.setJid(ord.getjMembercardId());
						//查询剩余积分数
						TMemberCard num = this.memberService.getInte(ord.getjMembercardId());
						//查询积分数兑换RMB数
						TDepartment getScore = this.tdService.selectScore(ord.getjDeptId());
						BigDecimal aaa = new BigDecimal(BigdecimalUtil.mul(ord.getjIfscore().doubleValue(),getScore.getJscoreforrmb().doubleValue()));
						tMemberCard.setJendqty(new BigDecimal(BigdecimalUtil.add(num.getJendqty().doubleValue(),aaa.doubleValue())));
						tMemberCard.setJoutfillamt(new BigDecimal(BigdecimalUtil.add(num.getJendfillamt().doubleValue(),ord.getjIfmembercard().doubleValue())));
						int out = this.memberService.updateall(tMemberCard);
						if(out==1){
							resultMap.put("data", out);
							resultMap.put("code", "100000");
							resultMap.put("message", "success");
						}else{
							resultMap.put("data", out);
							resultMap.put("code", "100002");
							resultMap.put("message", "退款失败！");
						}
	                }
	            }else{
	            	resultMap.put("data", resul);
	    			resultMap.put("code", "100002");
	    			resultMap.put("message", "退款失败，稍后重试！");
	            }
	            map.get("result_code");
	        } catch (IOException e) {
	            // TODO Auto-generated catch block  
	            e.printStackTrace();
	        }
    	} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pw.write(new Gson().toJson(resultMap));
			pw.close();
		}
    }

    @RequestMapping(value = "/json/money/wxpay/succ",
            produces = MediaType.APPLICATION_JSON_VALUE)
    /*@RequestDescription("支付回调地址")*/
    public void wxpaySucc(HttpServletRequest request, HttpServletResponse response,TOrderDetailed tOrderDetailed,TMemberCard tMemberCard) {
        System.out.println("微信支付回调");
    	try {
	        InputStream inStream = request.getInputStream();
	        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int len = 0;
	        while ((len = inStream.read(buffer)) != -1) {
	            outSteam.write(buffer, 0, len);
	        }
	        String resultxml = new String(outSteam.toByteArray(), "utf-8");
	        Map<String, String> params = PayCommonUtil.doXMLParse(resultxml);
	        outSteam.close();
	        inStream.close();
	        if (!PayCommonUtil.isTenpaySign("UTF-8",params)) {
	            // 支付失败
	        	System.out.println("fail");
	        } else {
	            System.out.println("===============付款成功==============");
	            // ------------------------------
	            // 处理业务开始
	            // ------------------------------
	            // 此处处理订单状态，结合自己的订单数据完成订单状态的更新
	            // ------------------------------
	            String total_fee = params.get("total_fee");
	            double v = Double.valueOf(total_fee) / 100;
	            Long jordercode = Long.valueOf(params.get("out_trade_no"));
	            //更新
	            //updateUserPay(userId, String.valueOf(v));
	
	            // 处理业务完毕
	            // ------------------------------
	            tOrderDetailed.setjOrdercode(jordercode.toString());
	            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				String data = df.format(new Date()).toString();
				Date paytime = df.parse(data);
				tOrderDetailed.setjPaytime(paytime);
				tOrderDetailed.setjUptime(paytime);
				tOrderDetailed.setjState("3");
				//修改订单状态
				int order = this.orderService.uporderstate(tOrderDetailed);
				if(order == 1){
					TOrderDetailed ord = this.orderService.getOrder(jordercode.toString());
					if(ord != null){
						//修改剩余积分、余额
						tMemberCard.setJid(ord.getjMembercardId());
						//查询剩余积分数
						TMemberCard num = this.memberService.getInte(ord.getjMembercardId());
						//查询积分数兑换RMB数
						TDepartment getScore = this.tdService.selectScore(ord.getjDeptId());
						BigDecimal aaa = new BigDecimal(BigdecimalUtil.mul(ord.getjIfscore().doubleValue(),getScore.getJscoreforrmb().doubleValue()));
						tMemberCard.setJendqty(new BigDecimal(BigdecimalUtil.sub(num.getJendqty().doubleValue(),aaa.doubleValue())));
						tMemberCard.setJoutfillamt(new BigDecimal(BigdecimalUtil.sub(num.getJendfillamt().doubleValue(),ord.getjIfmembercard().doubleValue())));
						int out = this.memberService.updateall(tMemberCard);
						System.out.println(out);
					}
					System.out.println("修改成功");
				}else{
					System.out.println("修改失败");
				}
	        }
    	} catch (IOException | JDOMException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
}