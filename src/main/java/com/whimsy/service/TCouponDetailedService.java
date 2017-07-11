package com.whimsy.service;

import java.util.List;

import com.whimsy.entity.TCouponDetailed;

public interface TCouponDetailedService {
	
	int deleteByPrimaryKey(Integer jId);

    int insert(TCouponDetailed record);

    int insertSelective(TCouponDetailed record);

    List<TCouponDetailed> getCoupon(Integer jmembercardid);
    
    TCouponDetailed getorderCoupon(Integer jid);
    
    TCouponDetailed CouponNumber(Integer jmembercardid);

    int upcoup(TCouponDetailed tCouponDetailed);

    int updateByPrimaryKey(TCouponDetailed record);
}
