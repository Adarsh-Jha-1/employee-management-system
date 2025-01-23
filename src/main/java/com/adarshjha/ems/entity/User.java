package com.adarshjha.ems.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

//username (String)
//password (String, encrypted)
//employee (One-to-One, Employee)
//email (String)
//isEnabled (Boolean)
//lastLogin (LocalDateTime)

@Entity
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	@OneToOne
	private Employee employee;
	private String email;
	private Boolean isEnabled;
	private LocalDateTime lastLogin;

}
