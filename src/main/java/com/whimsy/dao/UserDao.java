package com.whimsy.dao;

import com.whimsy.entity.User;

public interface UserDao {
	// 验证登陆
	Integer checkLogin(User user);

	// 验证用户名是否存在
	Integer checkUserExist(String userName);

	// 删除用户
	Integer delUser(Integer userId);

	// 注册
	Integer registerUser(User user);

	// 用户信息更新
	Integer updateUser(User user);

}