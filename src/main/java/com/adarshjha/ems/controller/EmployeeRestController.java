package com.adarshjha.ems.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adarshjha.ems.entity.Employee;
import com.adarshjha.ems.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping()
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee createdEmployee = employeeService.createEmployee(employee);
		return new ResponseEntity<Employee>(createdEmployee, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Iterable<Employee>> getAllEmployees() {
		return new ResponseEntity<Iterable<Employee>>(employeeService.getAllEmployee(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		ResponseEntity<Employee> responseEntity;
		if (employee.isPresent()) {
			responseEntity = new ResponseEntity<>(employee.get(), HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
		Employee employee = employeeService.updateEmployee(id, updatedEmployee);
		return employee != null ? new ResponseEntity<>(employee, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		Boolean isDeleted = employeeService.deleteById(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
