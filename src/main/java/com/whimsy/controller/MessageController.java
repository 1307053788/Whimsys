package com.whimsy.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whimsy.entity.Content;
import com.whimsy.entity.Message;
import com.whimsy.service.MessageService;

@Controller
public class MessageController {
	@Autowired
	private MessageService mService;

	// 发表信息
	@RequestMapping(value="addMsg")
	@ResponseBody//ajax
	public String addMsg(Message msg,Content content){
		mService.addMsg(msg,content);
		return null;
		
	}
	@RequestMapping(value="delMsg")
	@ResponseBody
	// 删除消息
	public String delMsg(Integer msgId){
		mService.delMsg(msgId);
		return null;
		
	}
	@RequestMapping(value="queryMsg")
	// 遍历消息
	public List<Message> Selected(){
		mService.Selected();
		return null;
		
	}
	@RequestMapping(value="SearchSelective")
	@ResponseBody
	// 根据条件查询信息
	List<Message> SearchSelective(@Param(value = "keyWord") String keyWord){
		mService.SearchSelective("%"+keyWord+"%");
		return null;
		
	}
}
