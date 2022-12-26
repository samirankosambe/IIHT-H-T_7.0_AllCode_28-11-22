package com.user.models;

import com.user.entity.User;

public class JwtResponse {
	private String jwtToken;
	private User user;
	public JwtResponse() {
		super();
	}
	public JwtResponse(String jwtToken, User user) {
		super();
		this.jwtToken = jwtToken;
		this.user = user;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
