package com.whimsy.dao;

import com.whimsy.entity.TMsgCode;

public interface TMsgCodeMapper {
	
	int insertCode(TMsgCode tMsgCode);
    
    TMsgCode selectCode(TMsgCode tMsgCode);
    
    int deleteCode(TMsgCode tMsgCode);
}