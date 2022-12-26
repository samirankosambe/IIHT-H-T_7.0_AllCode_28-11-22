package com.user.service;

import com.user.entity.User;

public interface IUserService {
	
	//Guest can create account
	Long createAccountforUser(User user);
	
	User findByUsername(String username);
	
	String getRoleByUserId(Long userId);
	

}
