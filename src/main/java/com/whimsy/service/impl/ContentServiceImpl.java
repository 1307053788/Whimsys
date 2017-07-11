package com.whimsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.ContentDao;
import com.whimsy.entity.Content;
import com.whimsy.service.ContentService;
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentDao cDao;
	@Override
	public int delContent(Integer contentId) {
		return cDao.delContent(contentId);
	}

	@Override
	public int addContent(Content content) {
		return cDao.addContent(content);
	}

	@Override
	public int updateBContent(Content content) {
		return cDao.updateBContent(content);
	}

	@Override
	public List<Content> Selected() {
		return cDao.Selected();
	}

}
