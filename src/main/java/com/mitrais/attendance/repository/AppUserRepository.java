package com.mitrais.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitrais.attendance.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String>{

	AppUser findByUsername(String username);
}
