package com.whimsy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TMemberCardMapper;
import com.whimsy.dao.TMsgCodeMapper;
import com.whimsy.entity.TMsgCode;
import com.whimsy.service.TMsgCodeService;
@Service
public class TMsgCodeServiceImpl implements TMsgCodeService {
	
	@Autowired
	private TMsgCodeMapper tmcMapper;

	@Override
	public int insertCode(TMsgCode tMsgCode) {
		// TODO Auto-generated method stub
		return tmcMapper.insertCode(tMsgCode);
	}

	@Override
	public TMsgCode selectCode(TMsgCode tMsgCode) {
		// TODO Auto-generated method stub
		return tmcMapper.selectCode(tMsgCode);
	}

	@Override
	public int deleteCode(TMsgCode tMsgCode) {
		// TODO Auto-generated method stub
		return tmcMapper.deleteCode(tMsgCode);
	}

}
