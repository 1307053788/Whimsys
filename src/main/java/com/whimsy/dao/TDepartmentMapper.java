package com.whimsy.dao;

import java.util.List;

import com.whimsy.entity.TDepartment;

public interface TDepartmentMapper {
    
	List<TDepartment> selectAll(TDepartment tDepartment);

	TDepartment selectSign(Integer jid);
	
	TDepartment selectScore(Integer jid);
	
	TDepartment selectPeisong(Integer jid);
	
	List<TDepartment> selectOne(Integer jid);
	
	List<TDepartment> selectTwo(Integer jid);
}