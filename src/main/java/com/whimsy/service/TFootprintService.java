package com.whimsy.service;

import java.util.List;

import com.whimsy.entity.TFootprint;

public interface TFootprintService {

	int deleteByPrimaryKey(Integer jId);

    int insertSelective(TFootprint record);

    List<TFootprint> selectFootprint(Integer jmembercardid,Integer jdeptid);

    int updateByPrimaryKeySelective(TFootprint record);
    
    TFootprint selectf(TFootprint tFootprint);

    int updatef(TFootprint tFootprint);
    
    int insertf(TFootprint tFootprint);
}
