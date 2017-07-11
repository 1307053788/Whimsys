package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.TOrderDetailedMapper;
import com.whimsy.entity.TOrderDetailed;
import com.whimsy.service.TOrderDetailedService;

@Service
public class TOrderDetailedServiceImpl implements TOrderDetailedService {

	@Autowired
	private TOrderDetailedMapper torMapper;

	@Override
	public int insert(TOrderDetailed record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setOrder(TOrderDetailed tOrderDetailed) {
		// TODO Auto-generated method stub
		return torMapper.setOrder(tOrderDetailed);
	}

	@Override
	public int setOrderdatiled(TOrderDetailed tOrderDetailed) {
		// TODO Auto-generated method stub
		return torMapper.setOrderdatiled(tOrderDetailed);
	}

	@Override
	public int updateByPrimaryKey(TOrderDetailed record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TOrderDetailed getOrderID(String jordercode) {
		// TODO Auto-generated method stub
		return torMapper.getOrderID(jordercode);
	}

	@Override
	public TOrderDetailed getOrder(String jordercode) {
		// TODO Auto-generated method stub
		return torMapper.getOrder(jordercode);
	}

	@Override
	public int deleteorder(Integer jId) {
		// TODO Auto-generated method stub
		return torMapper.deleteorder(jId);
	}

	@Override
	public int deleteorderdetailed(Integer jorderid) {
		// TODO Auto-generated method stub
		return torMapper.deleteorderdetailed(jorderid);
	}

	@Override
	public int uporderstate(TOrderDetailed tOrderDetailed) {
		// TODO Auto-generated method stub
		return torMapper.uporderstate(tOrderDetailed);
	}

	@Override
	public List<TOrderDetailed> getOrderAll(Integer jmembercardid) {
		// TODO Auto-generated method stub
		return torMapper.getOrderAll(jmembercardid);
	}

}
