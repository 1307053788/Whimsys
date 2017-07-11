package com.whimsy.service;

import java.util.List;

import com.whimsy.entity.TMain;

public interface TMainService {

	List<TMain> selectKeyword(TMain tMain);
	
	List<TMain> selectBanner(TMain tMain);
	
	List<TMain> selectxBanner(TMain tMain);
	
	List<TMain> selectMainKind(TMain tMain);
	
	List<TMain> selectActivity(TMain tMain);
	
	List<TMain> selectTGoods(TMain tMain);
	
    int insertSelective(TMain record);
}
