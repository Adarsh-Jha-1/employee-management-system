package com.adarshjha.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adarshjha.ems.entity.Employee;
import com.adarshjha.ems.entity.LeaveRequest;
import com.adarshjha.ems.enums.LeaveRequestStatus;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long>{
	Iterable<LeaveRequest> findByEmployee(Employee employee);
	Iterable<LeaveRequest> findByStatus(LeaveRequestStatus status);
}
