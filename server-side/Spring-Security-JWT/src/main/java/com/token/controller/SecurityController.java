package com.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.token.entity.JWTRequest;
import com.token.entity.JWTResponse;
import com.token.service.UserService;
import com.token.utility.JWTUtility;

@RestController
public class SecurityController {

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	Authentication authentication;

	@GetMapping("/")
	public String home() {
		return "Hello and Welcome to home page";
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/admin")
	public String admin() {
		return "Hello and Welcome to home page Admin";
	}

	@PostMapping("/auth")
	public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {
		authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = jwtUtility.generateToken(authentication);
		return new JWTResponse(token);
	}

}
