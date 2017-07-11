package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.ContentDao;
import com.whimsy.dao.MessageDao;
import com.whimsy.entity.Content;
import com.whimsy.entity.Message;
import com.whimsy.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
	private MessageDao mDao;
    @Autowired
    private ContentDao cDao;
	@Override
	public Integer addMsg(Message msg,Content content) {
		 cDao.addContent(content);
		 int result = mDao.addMsg(msg);
		return result;
	}

	@Override
	public Integer delMsg(Integer msgId) {
		return delMsg(msgId);
	}

	@Override
	public List<Message> Selected() {
		return mDao.Selected();
	}

	@Override
	public List<Message> SearchSelective(String keyWord) {
		return mDao.SearchSelective(keyWord);
	}

}
