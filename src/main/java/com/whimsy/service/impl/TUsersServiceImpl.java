package com.whimsy.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TUsersMapper;
import com.whimsy.entity.TUsers;
import com.whimsy.service.TUsersService;
@Service
public class TUsersServiceImpl implements TUsersService {

	@Autowired
	private TUsersMapper userMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer jid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TUsers record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TUsers record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TUsers selectUser(String jusercode, String jpassword) {
		// TODO Auto-generated method stub
		return userMapper.selectUser(jusercode, jpassword);
	}

	@Override
	public int updateByPrimaryKeySelective(TUsers record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TUsers record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
