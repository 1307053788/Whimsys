package com.whimsy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whimsy.dao.UserDao;
import com.whimsy.entity.User;
import com.whimsy.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserDao userDao;
	public Integer checkLogin(User user) {
		return userDao.checkLogin(user);
	}

	public Integer checkUserExist(String userName) {
		return userDao.checkUserExist(userName);
	}

	public Integer delUser(Integer userId) {
		return userDao.delUser(userId);
	}

	public Integer registerUser(User user) {
		return userDao.registerUser(user);
	}

	public Integer updateUser(User user) {
		return updateUser(user);
	}

}
