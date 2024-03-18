package com.spring.jpa.service;

import java.util.List;
import java.util.Optional;

import com.spring.jpa.model.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Optional<Employee> findById(long id);

	Employee save(Employee employee);

	void deleteById(long id);

	void deleteAll();

}
