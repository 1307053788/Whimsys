package com.whimsy.service;

import java.util.List;

import com.whimsy.entity.TShopCart;

public interface TShopCartService {
	
	TShopCart selectGoodsNumber(TShopCart tShopCart);

	List<TShopCart> selectShopCart(Integer jdepartmentid,Integer jmembercardid);
	
    int setShopCart(TShopCart tShopCart);

    int updateShopCart(TShopCart tShopCart);
    
    int deleteShopCart(TShopCart tShopCart);
    
    int ordelShop(Integer jgoodsid,Integer jmembercardid,Integer jdepartmentid);
}
