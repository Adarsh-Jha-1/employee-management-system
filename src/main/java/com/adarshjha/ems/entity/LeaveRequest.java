package com.adarshjha.ems.entity;

import java.time.LocalDate;

import com.adarshjha.ems.enums.LeaveStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;   // Start date of the leave
    private LocalDate endDate;     // End date of the leave
    private String reason;         // Reason for the leave

    @Enumerated(EnumType.STRING)
    private LeaveStatus status;    // Status of the leave request (e.g., Pending, Approved, Rejected)

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;     // Employee who requested the leave
}
