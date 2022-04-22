package com.mitrais.attendance.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitrais.attendance.entity.AppUser;


public interface AppUserService {

	AppUser saveUser(AppUser appUser);
	void addRoleToUser(String username, String roleName);
	AppUser getUserByUsername(String username);
	AppUser getUserById(String id);
	List<AppUser> getAllUsers();
    Page<AppUser> getUsersByPage(Pageable pageable);
    AppUser updateUser(AppUser appUser);
    void deleteUserById(String id);

}