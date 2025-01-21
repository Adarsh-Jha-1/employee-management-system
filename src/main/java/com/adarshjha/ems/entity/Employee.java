package com.adarshjha.ems.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Employee {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;              // Full name of the employee
    private String email;             // Email address of the employee
    private String phone;             // Employee's phone number
    private String address;           // Home address of the employee
    private String department;        // Department the employee belongs to (e.g., HR, IT, Marketing)
    private LocalDate hireDate;       // Date the employee was hired
    private String status;        
    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    
    @OneToMany(mappedBy = "employee")
    private List<LeaveRequest> leaveRequests;
    
    @OneToMany(mappedBy = "employee")
    private List<Attendance> attendances;

}
