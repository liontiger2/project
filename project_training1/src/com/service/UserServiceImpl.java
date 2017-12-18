package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDaoImpl;
import com.entity.User;
@Service
@Transactional
public class UserServiceImpl {
	@Resource
	private UserDaoImpl userdao;
	
	public User loginUserService(User user){
		return userdao.loginUser(user);
	}
	
	public void saveuser(User user){
		userdao.saveuser(user);
	}
	
	public boolean rePasswordService(User user){
		return userdao.rePasswordDao(user);
	}
	
	public void setNewPasswordService(User user){
		userdao.setNewPasswordDao(user);
	}
}
