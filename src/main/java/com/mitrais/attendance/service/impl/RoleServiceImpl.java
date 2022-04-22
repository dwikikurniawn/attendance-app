package com.mitrais.attendance.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitrais.attendance.entity.Role;
import com.mitrais.attendance.repository.RoleRepository;
import com.mitrais.attendance.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role saveRole(Role role) {
		logger.info("saveRole(): {}", role);
		return roleRepository.save(role);
	}

	@Override
	public Role getRoleByName(String name) {
		logger.info("getRoleByName(): {}", name);
		return roleRepository.findByName(name);
	}

	@Override
	public Role getRoleById(String id) {
		logger.info("getRoleById(): {}", id);
		return roleRepository.findById(id).get();
	}

	@Override
	public List<Role> getAllRoles() {
		logger.info("getAllRoles()");
		return roleRepository.findAll();
	}

	@Override
	public Page<Role> getRolesByPage(Pageable pageable) {
		logger.info("getRoleByPage() pageSize: {} pageNumber: {}", pageable.getPageSize(), pageable.getPageNumber());
		return roleRepository.findAll(pageable);
	}

	@Override
	public Role updateRole(Role role) {
		Role updatedRole = roleRepository.findById(role.getId()).get();
		updatedRole.setName(role.getName());
		roleRepository.save(updatedRole);
		return updatedRole;
	}

	@Override
	public void deleteRoleById(String id) {
		roleRepository.deleteById(id);
	}
}
