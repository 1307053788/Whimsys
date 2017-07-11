package com.whimsy.dao;

import com.whimsy.entity.TUsers;

public interface TUsersMapper {
    int deleteByPrimaryKey(Integer jid);

    int insert(TUsers record);

    int insertSelective(TUsers record);

    TUsers selectUser(String jusercode,String jpassword);

    int updateByPrimaryKeySelective(TUsers record);

    int updateByPrimaryKey(TUsers record);
}