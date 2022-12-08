package com.hr.entity;

import java.util.ArrayList;
import java.util.List;

public class HR {
	private Long userID;
	private String name;
	private String phone;
	List<Resource> resources = new ArrayList<>();
	
	public HR() {
		super();
	}
	public HR(Long userID, String name, String phone) {
		super();
		this.userID = userID;
		this.name = name;
		this.phone = phone;
	}
	public HR(Long userID, String name, String phone, List<Resource> resources) {
		super();
		this.userID = userID;
		this.name = name;
		this.phone = phone;
		this.resources = resources;
	}
	
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Resource> getResources() {
		return resources;
	}
	public void setResourses(List<Resource> resources) {
		this.resources = resources;
	}
	
	
}
