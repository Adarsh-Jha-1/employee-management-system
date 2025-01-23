package com.adarshjha.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adarshjha.ems.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

}
