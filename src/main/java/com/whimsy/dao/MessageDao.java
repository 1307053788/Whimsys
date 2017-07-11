package com.whimsy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.whimsy.entity.Message;

public interface MessageDao {
	// 发表信息
	Integer addMsg(Message msg);

	// 删除消息
	Integer delMsg(Integer msgId);

	// 遍历消息
	List<Message> Selected();
	
	// 根据条件查询信息
	List<Message> SearchSelective(@Param(value = "keyWord")String keyWord);
}