package com.adarshjha.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adarshjha.ems.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
