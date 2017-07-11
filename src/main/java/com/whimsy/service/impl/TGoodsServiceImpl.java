package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TGoodsMapper;
import com.whimsy.entity.TGoods;
import com.whimsy.service.TGoodsService;
@Service
public class TGoodsServiceImpl implements TGoodsService {

	@Autowired
	private TGoodsMapper tgsMapper;
	@Override
	public List<TGoods> getGoods(Integer jparentid, Integer jdepartmentid) {
		// TODO Auto-generated method stub
		return tgsMapper.getGoods(jparentid, jdepartmentid);
	}
	@Override
	public TGoods getGoodsDetails(Integer jid) {
		// TODO Auto-generated method stub
		return tgsMapper.getGoodsDetails(jid);
	}
	@Override
	public List<TGoods> getorderGoods(Integer jorderid) {
		// TODO Auto-generated method stub
		return tgsMapper.getorderGoods(jorderid);
	}

}
