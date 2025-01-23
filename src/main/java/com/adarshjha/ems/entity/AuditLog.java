package com.adarshjha.ems.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//id (Long)
//action (String)
//entity (String) (e.g., Employee, LeaveRequest)
//timestamp (LocalDateTime)
//user (String)
//details (String)
@Entity
@Getter
@Setter
public class AuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String entity;
	private LocalDateTime timeStamp;
	private String user;
	private String details;
	
}
