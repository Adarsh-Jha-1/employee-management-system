package com.adarshjha.ems.entity;

import java.time.LocalDate;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

//Employee
//id (Long)
//name (String)
//email (String)
//hireDate (LocalDate)
//salary (Double)
//role (Many-to-One, Role)
//phoneNumber (String)
//address (String)
//department (String)
//isActive (Boolean)


@Entity
@Getter
@Setter
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private LocalDate hireDate;
	private Double salary;
	@ManyToOne
	private Role role;
	private String phoneNumber;
	private String address;
	private String department;
	private Boolean isActive;
	

}
