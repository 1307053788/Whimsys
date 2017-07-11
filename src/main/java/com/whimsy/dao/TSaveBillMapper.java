package com.whimsy.dao;

import com.whimsy.entity.TSaveBill;

public interface TSaveBillMapper {
    int deleteByPrimaryKey(Integer jid);

    int insert(TSaveBill record);

    int insertSelective(TSaveBill record);

    TSaveBill selectByPrimaryKey(Integer jid);

    int updateByPrimaryKeySelective(TSaveBill record);

    int updateByPrimaryKey(TSaveBill record);
}