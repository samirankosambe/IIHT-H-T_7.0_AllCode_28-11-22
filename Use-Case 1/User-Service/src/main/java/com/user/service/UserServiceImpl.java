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
		if(userRepo.findByUsername(user.getUsername()).isPresent()) {
			return 0l;
		}
		User savedUser = userRepo.save(user);
		return savedUser.getUserID();
	}

	@Override
	public String getRoleByUserId(Long userId) {
		return userRepo.getRoleByUserId(userId);
	}

}
