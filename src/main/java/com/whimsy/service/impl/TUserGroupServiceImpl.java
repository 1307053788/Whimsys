package com.whimsy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TUserGroupMapper;
import com.whimsy.entity.TUserGroup;
import com.whimsy.service.TUserGroupService;
@Service 
public class TUserGroupServiceImpl implements TUserGroupService {
	@Autowired
	private TUserGroupMapper groupMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer jid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TUserGroup record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TUserGroup record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TUserGroup selectGroup(Integer jid) {
		// TODO Auto-generated method stub
		return groupMapper.selectGroup(jid);
	}

	@Override
	public int updateByPrimaryKeySelective(TUserGroup record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TUserGroup record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
