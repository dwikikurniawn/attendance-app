package com.mitrais.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitrais.attendance.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String>{

	Role findByName(String name);
}
