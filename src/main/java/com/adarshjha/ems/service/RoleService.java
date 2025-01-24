package com.adarshjha.ems.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adarshjha.ems.entity.Role;
import com.adarshjha.ems.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}
	
	public Iterable<Role> getAllRole() {
		return roleRepository.findAll();
	}
	
	public Optional<Role> getRoleById(Long id){
		return roleRepository.findById(id);
	}
	
	public Role updateRole(Long id, Role updatedRole) {
		if(roleRepository.existsById(id)) {
			updatedRole.setId(id);
			return roleRepository.save(updatedRole);
		}
		return null;
	}
	
	public Boolean deleteById(Long id) {
		if(roleRepository.existsById(id)) {
			roleRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
