package com.whimsy.service;

import com.whimsy.entity.TMemberCard;

public interface TMemberCardService {

	int rigester(TMemberCard tMemberCard);

	TMemberCard verRigester(TMemberCard tMemberCard);

	TMemberCard getToken(TMemberCard tMemberCard);
	
	TMemberCard getInte(Integer jid);
	
	TMemberCard phoneSer(TMemberCard tMemberCard);

	int updataToken(TMemberCard tMemberCard);
	
	int Sign(TMemberCard tMemberCard);
	
	int updateIn(TMemberCard tMemberCard);
	
	int updateall(TMemberCard tMemberCard);

	TMemberCard selectWechat(TMemberCard tMemberCard);
	
}
