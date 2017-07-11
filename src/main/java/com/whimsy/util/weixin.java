package com.whimsy.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.logging.LogFactory;

import com.whimsy.entity.WCPayGetPrePayIdReqInfo;

public class weixin {
	public String getXmlStr(WCPayGetPrePayIdReqInfo reqInfo) {  
		  
        Map<String,Object> params = new HashMap<String,Object>();  

        params.put("appid",reqInfo.getAppid());  //上面的appid，注意大小写  

        params.put("mch_id",reqInfo.getMch_id()); //商户id  

        params.put("key",reqInfo.getKey()); //appkey(api密匙)  

        params.put("body",reqInfo.getBody()); //商品描述  

        params.put("out_trade_no",reqInfo.getOut_trade_no()); //应用后台生成的订单id  

        params.put("total_fee",reqInfo.getTotal_fee()); //总金额  

        params.put("spbill_create_ip",reqInfo.getSpbill_create_ip()); //用户终端ip  

        params.put("notify_url",reqInfo.getNotify_url()); //异步通知URL  

        params.put("trade_type",reqInfo.getTrade_type()); //交易方式，参见微信接口文档  

        params.put("nonce_str",reqInfo.getNonce_str());  //32位随机数  
        try{  

                return WCPayUtils.getXmlFromParamsMap(params);  

        }catch (Exception e) {  

                LogFactory.getLog("Message").debug("生成xml字符串出错");  

        }  
        return null;
	}
}
