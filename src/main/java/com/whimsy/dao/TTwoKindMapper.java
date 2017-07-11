package com.whimsy.dao;

import java.util.List;

import com.whimsy.entity.TTwoKind;

public interface TTwoKindMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(TTwoKind record);

    int insertSelective(TTwoKind record);

    List<TTwoKind> selectTwo(TTwoKind tTwoKind);

    int updateByPrimaryKeySelective(TTwoKind record);

    int updateByPrimaryKey(TTwoKind record);
}