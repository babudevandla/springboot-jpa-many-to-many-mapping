package com.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.exception.ResourceNotFoundException;
import com.spring.jpa.model.Employee;
import com.spring.jpa.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:8084")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> tutorials = employeeService.findAll();
		if (tutorials.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(tutorials, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
		Employee employee = employeeService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Employee with id = " + id));
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee _employee = employeeService.save(employee);
		return new ResponseEntity<>(_employee, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateTutorial(@PathVariable("id") long id, @RequestBody Employee tutorial) {
		Employee _employee = employeeService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Employee with id = " + id));

		_employee.setFirstName(tutorial.getFirstName());
		_employee.setLastName(tutorial.getLastName());

		return new ResponseEntity<>(employeeService.save(_employee), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	public ResponseEntity<HttpStatus> deleteAllEmployee() {
		employeeService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
