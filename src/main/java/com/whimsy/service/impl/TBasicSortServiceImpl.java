package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TBasicSortMapper;
import com.whimsy.entity.TBasicSort;
import com.whimsy.service.TBasicSortService;
@Service
public class TBasicSortServiceImpl implements TBasicSortService {

	@Autowired
	private TBasicSortMapper tbMapper;
	
	@Override
	public List<TBasicSort> selectOne(Integer jid) {
		// TODO Auto-generated method stub
		return tbMapper.selectOne(jid);
	}


}
