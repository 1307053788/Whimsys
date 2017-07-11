package com.whimsy.dao;

import java.util.List;

import com.whimsy.entity.TActivity;

public interface TActivityMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(TActivity record);

    int insertSelective(TActivity record);

    TActivity getAct(Integer jId);
    
    TActivity getifGoods(Integer jgoodsid,Integer jdeptid);
    
    List<TActivity> gettGoodsList(Integer jactivityid);
    
    List<TActivity> getzGoodsList(Integer jactivityid);

    int updateByPrimaryKeySelective(TActivity record);

    int updateByPrimaryKey(TActivity record);
}