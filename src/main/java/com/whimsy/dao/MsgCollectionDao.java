package com.whimsy.dao;

import com.whimsy.entity.MsgCollectionKey;

public interface MsgCollectionDao {

	int deleteByPrimaryKey(MsgCollectionKey key);

	int insert(MsgCollectionKey record);

	int insertSelective(MsgCollectionKey record);
}