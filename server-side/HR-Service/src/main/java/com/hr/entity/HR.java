package com.hr.entity;

import java.util.ArrayList;
import java.util.List;

public class HR {
	private Long userID;
	private String name;
	private String phone;
	List<Resourse> resourses = new ArrayList<>();
	
	public HR() {
		super();
	}
	public HR(Long userID, String name, String phone) {
		super();
		this.userID = userID;
		this.name = name;
		this.phone = phone;
	}
	public HR(Long userID, String name, String phone, List<Resourse> resourses) {
		super();
		this.userID = userID;
		this.name = name;
		this.phone = phone;
		this.resourses = resourses;
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
	public List<Resourse> getResourses() {
		return resourses;
	}
	public void setResourses(List<Resourse> resourses) {
		this.resourses = resourses;
	}
	
	
}
