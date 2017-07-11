package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.VAuxGoodsStockMapper;
import com.whimsy.entity.VAuxGoodsStock;
import com.whimsy.service.VAuxGoodsStockService;
@Service
public class VAuxGoodsStockServiceImpl implements VAuxGoodsStockService {

	@Autowired
	private VAuxGoodsStockMapper vgsMapper;
	
	@Override
	public List<VAuxGoodsStock> getGoods(Integer jclassid, Integer jdeptid) {
		// TODO Auto-generated method stub
		return vgsMapper.getGoods(jclassid, jdeptid);
	}

	@Override
	public List<VAuxGoodsStock> searchGoods(VAuxGoodsStock vAuxGoodsStock) {
		// TODO Auto-generated method stub
		return vgsMapper.searchGoods(vAuxGoodsStock);
	}

}
