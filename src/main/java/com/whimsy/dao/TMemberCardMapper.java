package com.whimsy.dao;

import com.whimsy.entity.TMemberCard;

public interface TMemberCardMapper {

	int rigester(TMemberCard tMemberCard);

	TMemberCard verRigester(TMemberCard tMemberCard);
	
	TMemberCard getInte(Integer jid);

	TMemberCard getToken(TMemberCard tMemberCard);
	
	TMemberCard phoneSer(TMemberCard tMemberCard);

	int updataToken(TMemberCard tMemberCard);
	
	int updateIn(TMemberCard tMemberCard);
	
	int updateall(TMemberCard tMemberCard);
	
	int Sign(TMemberCard tMemberCard);
	
	TMemberCard selectWechat(TMemberCard tMemberCard);
    
}