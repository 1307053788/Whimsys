package com.whimsy.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.logging.LogFactory;

import com.whimsy.entity.WCPayGetPrePayIdReqInfo;

public class weixin {
	public String getXmlStr(WCPayGetPrePayIdReqInfo reqInfo) {  
		  
        Map<String,Object> params = new HashMap<String,Object>();  

        params.put("appid",reqInfo.getAppid());  //�����appid��ע���Сд  

        params.put("mch_id",reqInfo.getMch_id()); //�̻�id  

        params.put("key",reqInfo.getKey()); //appkey(api�ܳ�)  

        params.put("body",reqInfo.getBody()); //��Ʒ����  

        params.put("out_trade_no",reqInfo.getOut_trade_no()); //Ӧ�ú�̨���ɵĶ���id  

        params.put("total_fee",reqInfo.getTotal_fee()); //�ܽ��  

        params.put("spbill_create_ip",reqInfo.getSpbill_create_ip()); //�û��ն�ip  

        params.put("notify_url",reqInfo.getNotify_url()); //�첽֪ͨURL  

        params.put("trade_type",reqInfo.getTrade_type()); //���׷�ʽ���μ�΢�Žӿ��ĵ�  

        params.put("nonce_str",reqInfo.getNonce_str());  //32λ�����  
        try{  

                return WCPayUtils.getXmlFromParamsMap(params);  

        }catch (Exception e) {  

                LogFactory.getLog("Message").debug("����xml�ַ�������");  

        }  
        return null;
	}
}
