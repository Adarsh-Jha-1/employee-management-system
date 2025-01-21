package com.adarshjha.ems.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;            // Date of attendance
    private LocalTime checkInTime;     // Check-in time for the employee
    private LocalTime checkOutTime;    // Check-out time for the employee

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;         // Employee associated with this attendance record
}
