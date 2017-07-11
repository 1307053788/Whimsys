package com.whimsy.dao;

import java.util.List;

import com.whimsy.entity.VAuxGoodsStock;

public interface VAuxGoodsStockMapper {
	
	List<VAuxGoodsStock> getGoods(Integer jclassid,Integer jdeptid);
	
	List<VAuxGoodsStock> searchGoods(VAuxGoodsStock vAuxGoodsStock);
	
    int insert(VAuxGoodsStock record);

    int insertSelective(VAuxGoodsStock record);
}