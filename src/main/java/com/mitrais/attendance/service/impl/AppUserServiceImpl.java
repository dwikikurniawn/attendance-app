package com.mitrais.attendance.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mitrais.attendance.config.SecurityConfig;
import com.mitrais.attendance.entity.AppUser;
import com.mitrais.attendance.entity.Role;
import com.mitrais.attendance.repository.AppUserRepository;
import com.mitrais.attendance.repository.RoleRepository;
import com.mitrais.attendance.service.AppUserService;


@Service
public class AppUserServiceImpl implements AppUserService, UserDetailsService{

	Logger logger = LoggerFactory.getLogger(AppUserServiceImpl.class);
	SecurityConfig securityConfig = new SecurityConfig();
	
	@Autowired
	AppUserRepository appUserRepository;
	
	@Autowired
	RoleRepository roleRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("loadUserByUsername(): username: {}", username);
		AppUser appUser = appUserRepository.findByUsername(username);
		if(appUser == null) {
			logger.error("User not found with username: {}", username);
			throw new UsernameNotFoundException("User not found with username: " + username);
		} else {
			logger.info("User found with username: {}", username);
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
			appUser.getRoles().forEach(role -> {
				authorities.add(new SimpleGrantedAuthority(role.getName()));
			});
			User securityUser = new User(appUser.getUsername(), appUser.getPassword(), authorities);
			logger.info("loadUserByUsername(): securityUser{}", securityUser);
			return securityUser; 
		}
	}
	
	@Override
	public AppUser saveUser(AppUser appUser) {
		appUser.setPassword(securityConfig.bCryptPasswordEncoderBean().encode(appUser.getPassword()));
		return appUserRepository.save(appUser);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppUser appUser = appUserRepository.findByUsername(username);
		Role role = roleRepository.findByName(roleName);
		appUser.getRoles().add(role);
		appUserRepository.save(appUser);
	}

	@Override
	public AppUser getUserByUsername(String username) {
		return appUserRepository.findByUsername(username);
	}

	@Override
	public AppUser getUserById(String id) {
		return appUserRepository.findById(id).get();
	}

	@Override
	public List<AppUser> getAllUsers() {
		return appUserRepository.findAll();
	}

	@Override
	public Page<AppUser> getUsersByPage(Pageable pageable) {
		return appUserRepository.findAll(pageable);
	}

	@Override
	public AppUser updateUser(AppUser appUser) {
		appUser.setPassword(securityConfig.bCryptPasswordEncoderBean().encode(appUser.getPassword()));
		return appUserRepository.save(appUser);
	}

	@Override
	public void deleteUserById(String id) {
		appUserRepository.deleteById(id);
	}	
}
