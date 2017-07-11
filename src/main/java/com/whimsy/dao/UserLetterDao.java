package com.whimsy.dao;

import com.whimsy.entity.UserLetter;

public interface UserLetterDao {
    int deleteByPrimaryKey(Integer letterId);

    int insert(UserLetter record);

    int insertSelective(UserLetter record);

    UserLetter selectByPrimaryKey(Integer letterId);

    int updateByPrimaryKeySelective(UserLetter record);

    int updateByPrimaryKey(UserLetter record);
}