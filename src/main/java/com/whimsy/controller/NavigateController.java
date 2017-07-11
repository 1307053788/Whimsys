package com.whimsy.controller;



import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import java.io.InputStream;  
import java.util.Comparator;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.List;  
import java.util.Map;  
import java.util.Map.Entry;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.TreeMap;  
  
import org.dom4j.Attribute;  
import org.dom4j.Document;  
import org.dom4j.Element;  
import org.dom4j.io.SAXReader;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whimsy.entity.WCPayGetPrePayIdReqInfo;
import com.whimsy.service.TMemberCardService;

import ytx.org.apache.http.protocol.HTTP;

@Controller
public class NavigateController {	
	
	@Autowired
	private TMemberCardService tmService;
	
      //椤甸潰璺宠浆
	@RequestMapping(value="/payment")
	public String payment(HttpServletRequest request, HttpServletResponse response){
		
		return null;
	}
	@RequestMapping(value="/Wlogin")
	public String userLogin(){
		/*int a = tmService.Sign();*/
		return "";
	}
	@RequestMapping(value="/Wmain")
	public String userMain(){
		/*TimerUtil.showTimer();*/
		return "main";
	}
	@RequestMapping(value="/Mymain")
	public String myWain(){
		return "mymain";
	}
	
	/*@RequestMapping(value="/Mymains")
	public String myWains(HttpServletRequest request, HttpServletResponse response,String xmlStr,WCPayGetPrePayIdReqInfo respInfo){
		String appid = request.getParameter("jwechat");
		String mch_id = request.getParameter("jwechat");
		String key = request.getParameter("jwechat");
		String body = request.getParameter("jwechat");
		String out_trade_no = request.getParameter("jwechat");
		String total_fee = request.getParameter("jwechat");
		String spbill_create_ip = request.getParameter("jwechat");
		String notify_url = request.getParameter("jwechat");
		String trade_type = request.getParameter("jwechat");
		String nonce_str = WCPayUtils.getRandomNumber(32);
		respInfo.setAppid(appid);
		respInfo.setMch_id(mch_id);
		respInfo.setKey(key);
		respInfo.setBody(body);
		respInfo.setOut_trade_no(out_trade_no);
		respInfo.setTotal_fee(total_fee);
		respInfo.setSpbill_create_ip(spbill_create_ip);
		respInfo.setNotify_url(notify_url);
		respInfo.setTrade_type(trade_type);
		respInfo.setNonce_str(nonce_str);
		try {  
			SortedMap<String,String> params = new TreeMap<String,String>();
			params.put("appid", appid);
			params.put("mch_id", mch_id);
			params.put("key", key);
			params.put("body", body);
			params.put("out_trade_no", out_trade_no);
			params.put("total_fee", total_fee);
			params.put("spbill_create_ip", spbill_create_ip);
		    //parameters.put("nonce_str", nonce_str);
			params.put("notify_url", notify_url);
			params.put("trade_type", trade_type);
			params.put("nonce_str", nonce_str);
			String sign = WCPayUtils.getSignFromParamMap("UTF-8", params);
			
			
			
			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
			CloseableHttpClient closeableHttpClient = httpClientBuilder.build();  
			HttpPost httpPost =new HttpPost("https://api.mch.weixin.qq.com/pay/unifiedorder");  
			HttpClientContext context = HttpClientContext.create();  
			StringEntity se = new StringEntity(xmlStr);  
			se.setContentType("text/xml");  
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/xml"));  
			httpPost.setEntity(se);  
			httpPost.setConfig(RequestConfig.DEFAULT);  
			HttpResponse httpResponse = closeableHttpClient.execute(httpPost, context);  
			HttpEntity httpEntity= httpResponse.getEntity();
			if (httpEntity !=null) {  
				// 打印响应内容  
				InputStream content = httpEntity.getContent();  
				Map<String,String> params = WCPayUtils.getParamsMapFromXml(content);  
				params.put("key",pContect.getWcPayKey());
				if(params.containsKey("sign")&& params.get("prepay_id") != null && !"".equals(params.get("prepay_id"))&& !"null".equals(params.get("prepay_id"))){  
					if(WCPayUtils.checkSign(params)){   //签名认证成功  
						for(Map.Entry<String, String> param : params.entrySet()){  
							if("appid".equals(param.getKey()))  
								respInfo.setAppid(param.getValue());  
							else if("mch_id".equals(param.getKey()))  
								respInfo.setMch_id(param.getValue());  
							else if("prepay_id".equals(param.getKey()))  
								respInfo.setPrepay_id(param.getValue());//将prepayid放进WCPayGetPrePayIdRespInfo对象中  
							else 
								continue;  
						}  
					}else{  
						LogFactory.getLog("system").info("第一次响应签名认证失败");  
					}  
				}  
			}
			closeableHttpClient.close(); 
		} catch (Exception e) {  
			e.printStackTrace();  
		}
		return "mymain";
	}
	
	*/
}
