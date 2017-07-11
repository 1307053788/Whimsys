package com.whimsy.dao;

import com.whimsy.entity.MsgComment;

public interface MsgCommentDao {
    int deleteByPrimaryKey(Integer commentId);

    int insert(MsgComment record);

    int insertSelective(MsgComment record);

    MsgComment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(MsgComment record);

    int updateByPrimaryKey(MsgComment record);
}