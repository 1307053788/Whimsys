package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TActivityMapper;
import com.whimsy.entity.TActivity;
import com.whimsy.service.TActivityService;
@Service
public class TActivityServiceImpl implements TActivityService {

	@Autowired
	private TActivityMapper tactMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer jId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TActivity record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TActivity record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TActivity getAct(Integer jId) {
		// TODO Auto-generated method stub
		return tactMapper.getAct(jId);
	}

	@Override
	public List<TActivity> gettGoodsList(Integer jactivityid) {
		// TODO Auto-generated method stub
		return tactMapper.gettGoodsList(jactivityid);
	}
	
	@Override
	public List<TActivity> getzGoodsList(Integer jactivityid) {
		// TODO Auto-generated method stub
		return tactMapper.getzGoodsList(jactivityid);
	}

	@Override
	public int updateByPrimaryKeySelective(TActivity record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TActivity record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TActivity getifGoods(Integer jgoodsid, Integer jdeptid) {
		// TODO Auto-generated method stub
		return tactMapper.getifGoods(jgoodsid, jdeptid);
	}

}
