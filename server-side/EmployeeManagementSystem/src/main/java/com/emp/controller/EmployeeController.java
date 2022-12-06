package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entity.Employee;
import com.emp.service.IEmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;
	
	@PostMapping("/add")
	Integer createEmployee(Employee employee) {
		Integer id = employeeService.saveEmployee(employee);
		System.out.println(id);
		return id;
	}

}
