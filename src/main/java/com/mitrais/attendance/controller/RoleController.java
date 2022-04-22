package com.mitrais.attendance.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitrais.attendance.entity.Role;
import com.mitrais.attendance.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	@GetMapping
	public ResponseEntity<Page<Role>> getRolesByPage(@RequestParam Integer page, @RequestParam Integer size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return ResponseEntity.ok().body(roleService.getRolesByPage(pageable));
	}

	@PostMapping("/save")
	public ResponseEntity<Role> saveRoles(@RequestBody Role role) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role/save").toUriString());
		return ResponseEntity.created(uri).body(roleService.saveRole(role));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRoles(@PathVariable String id) {
		roleService.deleteRoleById(id);
		return ResponseEntity.ok().body(String.format("Delete role with id %s success", id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Role>> getAllRoles() {
		return ResponseEntity.ok().body(roleService.getAllRoles());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable String id) {
		return ResponseEntity.ok().body(roleService.getRoleById(id));
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Role> getRoleByName(@PathVariable String name) {
		return ResponseEntity.ok().body(roleService.getRoleByName(name));
	}

	@PostMapping("/update")
	public ResponseEntity<Role> updateRoles(@RequestBody Role role) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role/update").toUriString());
		return ResponseEntity.created(uri).body(roleService.updateRole(role));
	}
}