package com.adarshjha.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adarshjha.ems.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
