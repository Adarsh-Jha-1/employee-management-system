package com.adarshjha.ems.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
//
//LeaveRequest:
//id (Long)
//startDate (LocalDate)
//endDate (LocalDate)
//status (String) (e.g., Pending, Approved, Rejected)
//employee (Many-to-One, Employee)
//reason (String)
//comments (String)

@Entity
@Getter
@Setter
public class LeaveRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
	@ManyToOne
	private Employee employee;
	private String reason;
	private String comments;
}
