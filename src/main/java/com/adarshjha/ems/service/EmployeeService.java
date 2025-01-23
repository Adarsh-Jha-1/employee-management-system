package com.adarshjha.ems.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adarshjha.ems.entity.Employee;
import com.adarshjha.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee createEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	public Iterable<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> getEmployeeById(Long id){
		return employeeRepository.findById(id);
	}
	
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		if(employeeRepository.existsById(id)) {
			updatedEmployee.setId(id);
			return employeeRepository.save(updatedEmployee);
		}
		return null;
	}
	
	public Boolean deleteById(Long id) {
		if(employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
