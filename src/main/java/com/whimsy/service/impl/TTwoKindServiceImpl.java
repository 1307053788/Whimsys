package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TTwoKindMapper;
import com.whimsy.entity.TTwoKind;
import com.whimsy.service.TTwoKindService;
@Service
public class TTwoKindServiceImpl implements TTwoKindService {

	@Autowired
	private TTwoKindMapper ttkMapper;
	
	@Override
	public List<TTwoKind> selectTwo(TTwoKind tTwoKind) {
		// TODO Auto-generated method stub
		return ttkMapper.selectTwo(tTwoKind);
	}

}
