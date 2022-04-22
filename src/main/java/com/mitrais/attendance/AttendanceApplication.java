package com.mitrais.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AttendanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(RoleService roleService, AppUserService appUserService) {
//		return args -> {
//			roleService.saveRole(new Role("SUPER_ADMIN"));
//			roleService.saveRole(new Role("ADMIN"));
//			roleService.saveRole(new Role("USER"));
//			roleService.saveRole(new Role("MANAGER"));
//			
//			appUserService.saveUser(new AppUser("Jhon Travolta","jhontrav12","brazikowas","MALE", new ArrayList<>()));
//			appUserService.saveUser(new AppUser("Kennedy Birmingham","kenbirming","brayess","MALE", new ArrayList<>()));
//			appUserService.saveUser(new AppUser("Laura Potre","laurapotres","beautiful","FEMALE", new ArrayList<>()));
//			appUserService.saveUser(new AppUser("Jane Maddison","janemadd1413","madmudmid","FEMALE", new ArrayList<>()));
//			
//			appUserService.addRoleToUser("jhontrav12", "ADMIN");
//			appUserService.addRoleToUser("kenbirming", "SUPER_ADMIN");
//			appUserService.addRoleToUser("laurapotres", "USER");
//			appUserService.addRoleToUser("janemadd1413", "MANAGER");
//		};
//	}
}