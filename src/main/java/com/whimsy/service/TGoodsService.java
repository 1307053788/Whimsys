package com.whimsy.service;

import java.util.List;

import com.whimsy.entity.TGoods;

public interface TGoodsService {

	List<TGoods> getGoods(Integer jparentid,Integer jdepartmentid);
	
	TGoods getGoodsDetails(Integer jid);
	
	List<TGoods> getorderGoods(Integer jorderid);
}
