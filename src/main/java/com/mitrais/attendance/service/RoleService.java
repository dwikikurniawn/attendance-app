package com.mitrais.attendance.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitrais.attendance.entity.Role;

public interface RoleService {

	Role saveRole(Role role);
	Role getRoleByName(String name);
	Role getRoleById(String id);
	List<Role> getAllRoles();
    Page<Role> getRolesByPage(Pageable pageable);
    Role updateRole(Role role);
    void deleteRoleById(String id);
}
