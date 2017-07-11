package com.whimsy.dao;

import com.whimsy.entity.TOrder;

public interface TOrderMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Integer jId);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);
}