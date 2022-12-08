package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.IUserService;

@RestController
public class UserController {

	@Autowired
	IUserService userService;
}
