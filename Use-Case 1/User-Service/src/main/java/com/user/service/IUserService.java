package com.user.service;

import com.user.entity.User;

public interface IUserService {
	
	//Guest can create account
	Long createAccountforUser(User user);
	
	//Guest can login
	boolean logIn(String username, String password);
	
	String getRoleByUserId(Long id);
	

}
