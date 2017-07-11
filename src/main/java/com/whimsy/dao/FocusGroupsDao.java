package com.whimsy.dao;

import com.whimsy.entity.FocusGroups;
import com.whimsy.entity.FocusGroupsKey;

public interface FocusGroupsDao {
    int deleteByPrimaryKey(FocusGroupsKey key);

    int insert(FocusGroups record);

    int insertSelective(FocusGroups record);

    FocusGroups selectByPrimaryKey(FocusGroupsKey key);

    int updateByPrimaryKeySelective(FocusGroups record);

    int updateByPrimaryKey(FocusGroups record);
}