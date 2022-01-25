package com.bk.examportal;

import com.bk.examportal.model.Role;
import com.bk.examportal.model.User;
import com.bk.examportal.model.UserRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamPortalApplication {

//	@Autowired 
//	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Starting code");
//
//
//		User user = new User();
//		user.setEmail("bhautik@gmail.com");
//		user.setFirstName("bhautik");
//		user.setLastName("koshiya");
//		user.setPassword(this.bC);
//		user.setUserName("bhautik102");
//
//		user.setProfile("default.png");
//
//
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUserName());
//
//	}
}