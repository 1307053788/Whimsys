package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TDeliveryAddressMapper;
import com.whimsy.entity.TDeliveryAddress;
import com.whimsy.service.TDeliveryAddressService;
@Service
public class TDeliveryAddressServiceImpl implements TDeliveryAddressService {

	@Autowired
	private TDeliveryAddressMapper tdaMapper;
	
	@Override
	public int deleteAddress(Integer jId) {
		// TODO Auto-generated method stub
		return tdaMapper.deleteAddress(jId);
	}

	@Override
	public int addAddress(TDeliveryAddress tDeliveryAddress) {
		// TODO Auto-generated method stub
		return tdaMapper.addAddress(tDeliveryAddress);
	}

	@Override
	public int insertSelective(TDeliveryAddress record) {
		// TODO Auto-generated method stub
		return tdaMapper.insertSelective(record);
	}

	@Override
	public List<TDeliveryAddress> getAddress(Integer jMembercardId) {
		// TODO Auto-generated method stub
		return tdaMapper.getAddress(jMembercardId);
	}

	@Override
	public int updateAddress(TDeliveryAddress tDeliveryAddress) {
		// TODO Auto-generated method stub
		return tdaMapper.updateAddress(tDeliveryAddress);
	}

	@Override
	public int updateByPrimaryKey(TDeliveryAddress record) {
		// TODO Auto-generated method stub
		return tdaMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateDefault(Integer jmembercardid) {
		// TODO Auto-generated method stub
		return tdaMapper.updateDefault(jmembercardid);
	}

	@Override
	public TDeliveryAddress getorderAddress(Integer jId) {
		// TODO Auto-generated method stub
		return tdaMapper.getorderAddress(jId);
	}

}
