package com.adarshjha.ems.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

//id (Long)
//employee (Many-to-One, Employee)
//checkInTime (LocalTime)
//checkOutTime (LocalTime)
//date (LocalDate)
//location (String)

@Entity
@Getter
@Setter
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Employee employee;
	private LocalTime checkInTime;
	private LocalTime checkOutTime;
	private LocalDate date;
	private String location;
	

}
