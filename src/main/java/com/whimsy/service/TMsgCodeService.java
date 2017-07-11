package com.whimsy.service;

import com.whimsy.entity.TMsgCode;

public interface TMsgCodeService {
	int insertCode(TMsgCode tMsgCode);
    
    TMsgCode selectCode(TMsgCode tMsgCode);
    
    int deleteCode(TMsgCode tMsgCode);
}
