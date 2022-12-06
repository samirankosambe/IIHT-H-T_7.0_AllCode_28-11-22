package com.emp.entity;

public class Employee {
	private Integer id;
	private String ename;
	private String eposition;
	private String email;
	private Integer salary;
	
	public Employee() {
		super();
	}
	
	public Employee(Integer id, String ename, String eposition, String email, Integer salary) {
		super();
		this.id = id;
		this.ename = ename;
		this.eposition = eposition;
		this.email = email;
		this.salary = salary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEposition() {
		return eposition;
	}
	public void setEposition(String eposition) {
		this.eposition = eposition;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
}
