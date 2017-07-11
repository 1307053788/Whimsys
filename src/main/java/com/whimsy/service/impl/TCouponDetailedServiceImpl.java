package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TCouponDetailedMapper;
import com.whimsy.entity.TCouponDetailed;
import com.whimsy.service.TCouponDetailedService;
@Service
public class TCouponDetailedServiceImpl implements TCouponDetailedService {

	@Autowired
	private TCouponDetailedMapper tcdMapper;
	@Override
	public int deleteByPrimaryKey(Integer jId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCouponDetailed record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCouponDetailed record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TCouponDetailed> getCoupon(Integer jmembercardid) {
		// TODO Auto-generated method stub
		return tcdMapper.getCoupon(jmembercardid);
	}

	@Override
	public int updateByPrimaryKey(TCouponDetailed record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCouponDetailed CouponNumber(Integer jmembercardid) {
		// TODO Auto-generated method stub
		return tcdMapper.CouponNumber(jmembercardid);
	}

	@Override
	public TCouponDetailed getorderCoupon(Integer jid) {
		// TODO Auto-generated method stub
		return tcdMapper.getorderCoupon(jid);
	}

	@Override
	public int upcoup(TCouponDetailed tCouponDetailed) {
		// TODO Auto-generated method stub
		return tcdMapper.upcoup(tCouponDetailed);
	}

}
