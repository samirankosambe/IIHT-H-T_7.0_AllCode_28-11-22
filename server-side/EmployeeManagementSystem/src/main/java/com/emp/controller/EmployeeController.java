package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entity.Employee;
import com.emp.service.IEmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;
	
	@PostMapping("/add")
	Integer createEmployee(@RequestBody Employee employee) {
		Integer id = employeeService.saveEmployee(employee);
		System.out.println(id);
		return id;
	}
	
	@GetMapping("/getall")
	List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}

}
