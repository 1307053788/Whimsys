package com.whimsy.dao;

import java.util.List;

import com.whimsy.entity.TIntegration;

public interface TIntegrationMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(TIntegration record);

    int insertIn(TIntegration tIntegration);

    List<TIntegration> selectIntegration(Integer jmembercardid);

    int updateByPrimaryKeySelective(TIntegration record);

    int updateByPrimaryKey(TIntegration record);
}