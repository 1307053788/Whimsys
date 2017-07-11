package com.whimsy.service;

import java.util.List;

import com.whimsy.entity.TActivity;

public interface TActivityService {

	int deleteByPrimaryKey(Integer jId);

    int insert(TActivity record);

    int insertSelective(TActivity record);

    TActivity getAct(Integer jId);
    
    List<TActivity> gettGoodsList(Integer jactivityid);
    
    List<TActivity> getzGoodsList(Integer jactivityid);
    
    TActivity getifGoods(Integer jgoodsid,Integer jdeptid);

    int updateByPrimaryKeySelective(TActivity record);

    int updateByPrimaryKey(TActivity record);
}
