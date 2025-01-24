package com.adarshjha.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adarshjha.ems.entity.Role;
import com.adarshjha.ems.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleRestController {

	@Autowired
	RoleService roleService;

	@PostMapping
	public ResponseEntity<Role> createRole(@RequestBody Role role) {
		return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Iterable<Role>> getRoles() {
		return new ResponseEntity<Iterable<Role>>(roleService.getAllRole(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable("id") Long id) {
		return roleService.getRoleById(id).map(role -> new ResponseEntity<Role>(role, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<Role>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role updatedRole) {
		return roleService.getRoleById(id).map(role -> {
			roleService.updateRole(id, updatedRole);
			return new ResponseEntity<>(updatedRole, HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteRole(@PathVariable Long id) {
//		return roleService.getRoleById(id).map(role -> {	
//			roleService.deleteById(id);
//			return new ResponseEntity<>(true, HttpStatus.OK);
//		}).orElseGet(() -> new ResponseEntity<>(false, HttpStatus.NOT_FOUND));

		return roleService.deleteById(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
