package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TDeptScopeMapper;
import com.whimsy.entity.TDeptScope;
import com.whimsy.service.TDeptScopeService;
@Service
public class TDeptScopeServiceImpl implements TDeptScopeService {

	@Autowired
	private TDeptScopeMapper dscopeMapper;
	@Override
	public int deleteByPrimaryKey(Integer jId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TDeptScope record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TDeptScope record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TDeptScope> selectScope(Integer jDeptid) {
		// TODO Auto-generated method stub
		return dscopeMapper.selectScope(jDeptid);
	}

	@Override
	public int updateByPrimaryKeySelective(TDeptScope record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TDeptScope record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
