package com.whimsy.service;

import java.util.List;

import com.whimsy.entity.TDepartment;

public interface TDepartmentService {
	
    List<TDepartment> selectAll(TDepartment tDepartment);
    
    TDepartment selectSign(Integer jid);

    TDepartment selectScore(Integer jid);
    
    TDepartment selectPeisong(Integer jid);
    
    List<TDepartment> selectOne(Integer jid);
	
    List<TDepartment> selectTwo(Integer jid);
}
