package com.whimsy.service;

import com.whimsy.entity.TUsers;

public interface TUsersService {

	int deleteByPrimaryKey(Integer jid);

    int insert(TUsers record);

    int insertSelective(TUsers record);

    TUsers selectUser(String jusercode,String jpassword);

    int updateByPrimaryKeySelective(TUsers record);

    int updateByPrimaryKey(TUsers record);
}
