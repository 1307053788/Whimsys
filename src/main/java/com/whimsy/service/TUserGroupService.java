package com.whimsy.service;

import com.whimsy.entity.TUserGroup;

public interface TUserGroupService {

	int deleteByPrimaryKey(Integer jid);

    int insert(TUserGroup record);

    int insertSelective(TUserGroup record);

    TUserGroup selectGroup(Integer jid);

    int updateByPrimaryKeySelective(TUserGroup record);

    int updateByPrimaryKey(TUserGroup record);
}
