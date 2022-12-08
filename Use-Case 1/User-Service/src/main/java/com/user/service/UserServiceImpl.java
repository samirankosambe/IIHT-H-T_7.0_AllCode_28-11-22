package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.repo.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepo userRepo;

}
