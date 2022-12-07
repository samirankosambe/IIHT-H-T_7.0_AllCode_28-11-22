package com.hr.entity;

public class Resourse {
	private Long resourceID;
	private String email;
	private String resourseName;
	private String domain;
	private Long userID;

	public Resourse() {
		super();
	}
	public Resourse(Long resourceID, String email, String resourseName, String domain, Long userID) {
		super();
		this.resourceID = resourceID;
		this.email = email;
		this.resourseName = resourseName;
		this.domain = domain;
		this.userID = userID;
	}
	
	public Long getResourceID() {
		return resourceID;
	}
	public void setResourceID(Long resourceID) {
		this.resourceID = resourceID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getResourseName() {
		return resourseName;
	}
	public void setResourseName(String resourseName) {
		this.resourseName = resourseName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	
}
