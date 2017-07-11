package com.whimsy.service;

import java.util.List;

import com.whimsy.entity.TDeliveryAddress;

public interface TDeliveryAddressService {
	
	int deleteAddress(Integer jId);

    int addAddress(TDeliveryAddress tDeliveryAddress);

    int insertSelective(TDeliveryAddress record);

    List<TDeliveryAddress> getAddress(Integer jMembercardId);
    
    TDeliveryAddress getorderAddress(Integer jId);

    int updateAddress(TDeliveryAddress tDeliveryAddress);
    
    int updateDefault(Integer jmembercardid);

    int updateByPrimaryKey(TDeliveryAddress record);
    
}
