package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TShopCartMapper;
import com.whimsy.entity.TShopCart;
import com.whimsy.service.TShopCartService;
@Service
public class TShopCartServiceImpl implements TShopCartService {

	@Autowired
	private TShopCartMapper tscMapper;
	
	@Override
	public List<TShopCart> selectShopCart(Integer jdepartmentid,Integer jmembercardid) {
		// TODO Auto-generated method stub
		List<TShopCart> l =  tscMapper.selectShopCart(jdepartmentid,jmembercardid);
		
		return l;
	}

	@Override
	public int setShopCart(TShopCart tShopCart) {
		// TODO Auto-generated method stub
		return tscMapper.setShopCart(tShopCart);
	}

	@Override
	public int updateShopCart(TShopCart tShopCart) {
		// TODO Auto-generated method stub
		return tscMapper.updateShopCart(tShopCart);
	}

	@Override
	public int deleteShopCart(TShopCart tShopCart) {
		// TODO Auto-generated method stub
		return tscMapper.deleteShopCart(tShopCart);
	}

	@Override
	public TShopCart selectGoodsNumber(TShopCart tShopCart) {
		// TODO Auto-generated method stub
		return tscMapper.selectGoodsNumber(tShopCart);
	}

	@Override
	public int ordelShop(Integer jgoodsid, Integer jmembercardid, Integer jdepartmentid) {
		// TODO Auto-generated method stub
		return tscMapper.ordelShop(jgoodsid, jmembercardid, jdepartmentid);
	}

}
