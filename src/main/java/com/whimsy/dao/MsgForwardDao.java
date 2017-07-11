package com.whimsy.dao;

import com.whimsy.entity.MsgForwardKey;

public interface MsgForwardDao {
    int deleteByPrimaryKey(MsgForwardKey key);

    int insert(MsgForwardKey record);

    int insertSelective(MsgForwardKey record);
}