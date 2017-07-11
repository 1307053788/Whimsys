package com.whimsy.service;

import java.util.List;

import com.whimsy.entity.VAuxGoodsStock;

public interface VAuxGoodsStockService {
	
	List<VAuxGoodsStock> getGoods(Integer jclassid,Integer jdeptid);

	List<VAuxGoodsStock> searchGoods(VAuxGoodsStock vAuxGoodsStock);
	
}
