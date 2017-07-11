package com.whimsy.service;

import java.util.List;

import com.whimsy.entity.TOrderDetailed;

public interface TOrderDetailedService {

	int deleteorder(Integer jId);
    
    int deleteorderdetailed(Integer jorderid);

    int insert(TOrderDetailed record);

    int setOrder(TOrderDetailed tOrderDetailed);
    
    int setOrderdatiled(TOrderDetailed tOrderDetailed);

    TOrderDetailed getOrderID(String jordercode);
    
    TOrderDetailed getOrder(String jordercode);
    
    List<TOrderDetailed> getOrderAll(Integer jmembercardid);

    int uporderstate(TOrderDetailed tOrderDetailed);

    int updateByPrimaryKey(TOrderDetailed record);
}
