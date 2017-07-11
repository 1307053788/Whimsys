package com.whimsy.dao;

import com.whimsy.entity.Photo;

public interface PhotoDao {
    int deleteByPrimaryKey(Integer photoId);

    int insert(Photo record);

    int insertSelective(Photo record);

    Photo selectByPrimaryKey(Integer photoId);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}