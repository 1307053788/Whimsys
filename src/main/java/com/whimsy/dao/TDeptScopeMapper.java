package com.whimsy.dao;

import java.util.List;

import com.whimsy.entity.TDeptScope;

public interface TDeptScopeMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(TDeptScope record);

    int insertSelective(TDeptScope record);

    List<TDeptScope> selectScope(Integer jDeptid);

    int updateByPrimaryKeySelective(TDeptScope record);

    int updateByPrimaryKey(TDeptScope record);
}