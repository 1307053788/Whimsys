package com.whimsy.dao;

import com.whimsy.entity.TTwokindBill;

public interface TTwokindBillMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(TTwokindBill record);

    int insertSelective(TTwokindBill record);

    TTwokindBill selectByPrimaryKey(Integer jId);

    int updateByPrimaryKeySelective(TTwokindBill record);

    int updateByPrimaryKey(TTwokindBill record);
}