package com.emp.service;

import java.util.List;
import java.util.Optional;

import com.emp.entity.Employee;

public interface IEmployeeService {
	Integer saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Optional<Employee> getEmployee(Integer id);

	void deleteEmployee(Integer id);

	Employee updateEmployee(Employee employee, Integer id);
}
