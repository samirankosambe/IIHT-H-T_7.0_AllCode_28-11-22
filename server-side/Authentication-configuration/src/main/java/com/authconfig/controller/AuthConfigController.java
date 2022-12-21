package com.authconfig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthConfigController {
	
	@GetMapping("/")
	public String getWelcome() {
		return "welcome";
	}
	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
}
