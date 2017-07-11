package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TMainMapper;
import com.whimsy.entity.TMain;
import com.whimsy.service.TMainService;
@Service
public class TMainServiceImpl implements TMainService {

	@Autowired
	private TMainMapper tMainMapper;
	
	@Override
	public List<TMain> selectKeyword(TMain tMain) {
		// TODO Auto-generated method stub
		return tMainMapper.selectKeyword(tMain);
	}

	@Override
	public List<TMain> selectBanner(TMain tMain) {
		// TODO Auto-generated method stub
		return tMainMapper.selectBanner(tMain);
	}

	@Override
	public List<TMain> selectxBanner(TMain tMain) {
		// TODO Auto-generated method stub
		return tMainMapper.selectxBanner(tMain);
	}

	@Override
	public List<TMain> selectMainKind(TMain tMain) {
		// TODO Auto-generated method stub
		return tMainMapper.selectMainKind(tMain);
	}

	@Override
	public List<TMain> selectActivity(TMain tMain) {
		// TODO Auto-generated method stub
		return tMainMapper.selectActivity(tMain);
	}

	@Override
	public List<TMain> selectTGoods(TMain tMain) {
		// TODO Auto-generated method stub
		return tMainMapper.selectTGoods(tMain);
	}

	@Override
	public int insertSelective(TMain record) {
		// TODO Auto-generated method stub
		return tMainMapper.insertSelective(record);
	}

}
