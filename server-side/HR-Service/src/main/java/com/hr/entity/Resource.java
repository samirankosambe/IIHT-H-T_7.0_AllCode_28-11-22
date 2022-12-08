package com.hr.entity;

public class Resource {
	private Long resourceID;
	private String email;
	private String resourceName;
	private String domain;
	private Long userID;

	public Resource() {
		super();
	}
	public Resource(Long resourceID, String email, String resourceName, String domain, Long userID) {
		super();
		this.resourceID = resourceID;
		this.email = email;
		this.resourceName = resourceName;
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
	public String getResourceName() {
		return resourceName;
	}
	public void setResourseName(String resourceName) {
		this.resourceName = resourceName;
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