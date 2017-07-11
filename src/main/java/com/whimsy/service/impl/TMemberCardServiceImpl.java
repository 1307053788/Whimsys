package com.whimsy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TMemberCardMapper;
import com.whimsy.entity.TMemberCard;
import com.whimsy.service.TMemberCardService;
@Service
public class TMemberCardServiceImpl implements TMemberCardService {
	@Autowired
	private TMemberCardMapper tmMapper;
	
	@Override
	public int rigester(TMemberCard tMemberCard) {
		// TODO Auto-generated method stub
		return tmMapper.rigester(tMemberCard);
	}
	
	@Override
	public TMemberCard verRigester(TMemberCard tMemberCard) {
		// TODO Auto-generated method stub
		return this.tmMapper.verRigester(tMemberCard);
	}

	@Override
	public TMemberCard getToken(TMemberCard tMemberCard) {
		// TODO Auto-generated method stub
		return tmMapper.getToken(tMemberCard);
	}

	@Override
	public int updataToken(TMemberCard tMemberCard) {
		// TODO Auto-generated method stub
		return tmMapper.updataToken(tMemberCard);
	}

	@Override
	public TMemberCard phoneSer(TMemberCard tMemberCard) {
		// TODO Auto-generated method stub
		return tmMapper.phoneSer(tMemberCard);
	}

	@Override
	public TMemberCard selectWechat(TMemberCard tMemberCard) {
		// TODO Auto-generated method stub
		return tmMapper.selectWechat(tMemberCard);
	}

	@Override
	public int Sign(TMemberCard tMemberCard) {
		// TODO Auto-generated method stub
		return tmMapper.Sign(tMemberCard);
	}

	@Override
	public TMemberCard getInte(Integer jid) {
		// TODO Auto-generated method stub
		return tmMapper.getInte(jid);
	}

	@Override
	public int updateIn(TMemberCard tMemberCard) {
		// TODO Auto-generated method stub
		return tmMapper.updateIn(tMemberCard);
	}

	@Override
	public int updateall(TMemberCard tMemberCard) {
		// TODO Auto-generated method stub
		return tmMapper.updateall(tMemberCard);
	}

}
