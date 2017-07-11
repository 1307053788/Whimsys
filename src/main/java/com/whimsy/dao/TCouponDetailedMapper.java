package com.whimsy.dao;

import java.util.List;

import com.whimsy.entity.TCouponDetailed;

public interface TCouponDetailedMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(TCouponDetailed record);

    int insertSelective(TCouponDetailed record);

    List<TCouponDetailed> getCoupon(Integer jmembercardid);
    
    TCouponDetailed getorderCoupon(Integer jid);
    
    TCouponDetailed CouponNumber(Integer jmembercardid);

    int upcoup(TCouponDetailed tCouponDetailed);

    int updateByPrimaryKey(TCouponDetailed record);
}