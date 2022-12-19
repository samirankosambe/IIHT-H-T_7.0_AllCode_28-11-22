package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repo.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepo userRepo;

	@Override
	public Long createAccountforUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean logIn(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getRoleByUserId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
