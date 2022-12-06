package com.emp.service;

import java.util.List;

import com.emp.entity.Employee;

public interface IEmployeeService {
	Integer saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
}
