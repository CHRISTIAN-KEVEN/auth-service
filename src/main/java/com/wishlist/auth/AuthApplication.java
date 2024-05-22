package com.wishlist.auth;

import com.wishlist.auth.models.TRole;
import com.wishlist.auth.models.TUser;
import com.wishlist.auth.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.createRole(new TRole(null, "ROLE_USER"));
			userService.createRole(new TRole(null, "ROLE_MANAGER"));
			userService.createRole(new TRole(null, "ROLE_ADMIN"));

			userService.createUser(new TUser(null, "John Travolta", "john", "johnny12", "678491481", "MALE", "", new ArrayList<>()));
			userService.createUser(new TUser(null, "Will Smith", "will", "smith15", "68015467", "MALE", "", new ArrayList<>()));
			userService.createUser(new TUser(null, "Jim Carry", "jim", "carry675", "6785680", "MALE", "", new ArrayList<>()));
			userService.createUser(new TUser(null, "Arnold Schwarzzenegger", "arnold", "arnold98", "678491481", "MALE", "", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("will", "ROLE_MANAGER");
			userService.addRoleToUser("jim", "ROLE_USER");
			userService.addRoleToUser("jim", "ROLE_MANAGER");
			userService.addRoleToUser("arnold", "ROLE_USER");
			userService.addRoleToUser("arnold", "ROLE_MANAGER");
			userService.addRoleToUser("arnold", "ROLE_ADMIN");

		};
	}

}
