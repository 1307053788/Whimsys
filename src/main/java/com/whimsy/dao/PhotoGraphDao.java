package com.whimsy.dao;

import com.whimsy.entity.PhotoGraph;

public interface PhotoGraphDao {
    int deleteByPrimaryKey(Integer photographId);

    int insert(PhotoGraph record);

    int insertSelective(PhotoGraph record);

    PhotoGraph selectByPrimaryKey(Integer photographId);

    int updateByPrimaryKeySelective(PhotoGraph record);

    int updateByPrimaryKey(PhotoGraph record);
}