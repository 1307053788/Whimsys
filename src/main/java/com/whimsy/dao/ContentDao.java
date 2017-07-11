package com.whimsy.dao;

import java.util.List;

import com.whimsy.entity.Content;

public interface ContentDao {
	//删除消息
    int delContent(Integer contentId);
    //添加消息
    int addContent(Content content);
    //更新消息
    int updateBContent(Content content);
    //遍历消息
    List<Content> Selected();
}