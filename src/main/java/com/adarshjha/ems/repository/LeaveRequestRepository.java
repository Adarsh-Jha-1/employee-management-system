package com.adarshjha.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adarshjha.ems.entity.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long>{

}
