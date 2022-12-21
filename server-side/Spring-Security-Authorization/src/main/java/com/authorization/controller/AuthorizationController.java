package com.authorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController {
	
	@GetMapping("/")
	public String getWelcome() {
		return "welcome";
	}
	@GetMapping("/user")
	public String getHelloUser() {
		return "hello User";
	}
	
	@GetMapping("/admin")
	public String getHelloAdmin() {
		return "hello Admin";
	}

}
