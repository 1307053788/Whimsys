package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TFootprintMapper;
import com.whimsy.entity.TFootprint;
import com.whimsy.service.TFootprintService;
@Service
public class TFootprintServiceImpl implements TFootprintService {

	@Autowired
	private TFootprintMapper tftMapper;
	@Override
	public int deleteByPrimaryKey(Integer jId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertf(TFootprint tFootprint) {
		// TODO Auto-generated method stub
		return tftMapper.insertf(tFootprint);
	}

	@Override
	public int insertSelective(TFootprint record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TFootprint> selectFootprint(Integer jmembercardid, Integer jdeptid) {
		// TODO Auto-generated method stub
		return tftMapper.selectFootprint(jmembercardid, jdeptid);
	}

	@Override
	public int updateByPrimaryKeySelective(TFootprint record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatef(TFootprint tFootprint) {
		// TODO Auto-generated method stub
		return tftMapper.updatef(tFootprint);
	}

	@Override
	public TFootprint selectf(TFootprint tFootprint) {
		// TODO Auto-generated method stub
		return tftMapper.selectf(tFootprint);
	}

}
