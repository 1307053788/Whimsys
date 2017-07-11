package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TIntegrationMapper;
import com.whimsy.entity.TIntegration;
import com.whimsy.service.TIntegrationService;
@Service
public class TIntegrationServiceImpl implements TIntegrationService {

	@Autowired
	private TIntegrationMapper tttMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer jId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TIntegration record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertIn(TIntegration tIntegration) {
		// TODO Auto-generated method stub
		return tttMapper.insertIn(tIntegration);
	}

	@Override
	public int updateByPrimaryKeySelective(TIntegration record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TIntegration record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TIntegration> selectIntegration(Integer jmembercardid) {
		// TODO Auto-generated method stub
		return tttMapper.selectIntegration(jmembercardid);
	}

}
