package com.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.entity.Employee;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

}
