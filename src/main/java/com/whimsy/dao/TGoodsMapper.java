package com.whimsy.dao;

import java.util.List;

import com.whimsy.entity.TGoods;

public interface TGoodsMapper {
    int deleteByPrimaryKey(Integer jid);

    int insert(TGoods record);

    int insertSelective(TGoods record);

    List<TGoods> getGoods(Integer jparentid,Integer jdepartmentid);
    
    List<TGoods> getorderGoods(Integer jorderid);
    
    TGoods getGoodsDetails(Integer jid);

    int updateByPrimaryKeySelective(TGoods record);

    int updateByPrimaryKeyWithBLOBs(TGoods record);

    int updateByPrimaryKey(TGoods record);
}