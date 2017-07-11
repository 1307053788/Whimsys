package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TDepartmentMapper;
import com.whimsy.entity.TDepartment;
import com.whimsy.service.TDepartmentService;
@Service
public class TDepartmentServiceImpl implements TDepartmentService {

	@Autowired
	private TDepartmentMapper tdMapper;
	
	@Override
	public List<TDepartment> selectAll(TDepartment tDepartment) {
		// TODO Auto-generated method stub
		return tdMapper.selectAll(tDepartment);
	}

	@Override
	public TDepartment selectSign(Integer jid) {
		// TODO Auto-generated method stub
		return tdMapper.selectSign(jid);
	}

	@Override
	public TDepartment selectScore(Integer jid) {
		// TODO Auto-generated method stub
		return tdMapper.selectScore(jid);
	}

	@Override
	public TDepartment selectPeisong(Integer jid) {
		// TODO Auto-generated method stub
		return tdMapper.selectPeisong(jid);
	}

	@Override
	public List<TDepartment> selectOne(Integer jid) {
		// TODO Auto-generated method stub
		return tdMapper.selectOne(jid);
	}

	@Override
	public List<TDepartment> selectTwo(Integer jid) {
		// TODO Auto-generated method stub
		return tdMapper.selectTwo(jid);
	}

}
