package com.ecom;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ecom.helper.UserFoundException;
import com.ecom.model.Role;
import com.ecom.model.User;
import com.ecom.model.UserRole;
import com.ecom.service.UserService;

@SpringBootApplication
public class SpringEComApplication  implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;

	public static void main(String[] args) {
		SpringApplication.run(SpringEComApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
		System.out.println("Stating Code");
		
		  User user = new User();
		  user.setFirstName("Ashish");
		  user.setLastName("Wankar");
		  user.setEmail("aaw.wankar9@gmail.com");
		  user.setUsername("ashish1711");
		  user.setPassword(bCrypt.encode("ashu1711"));
          
		  Role role = new Role();
		  
		  role.setRoleId(01L);
		  role.setRoleName("ADMIN");
		  
		  Set<UserRole> userroleSet = new HashSet<>();
		  
		  UserRole userRole = new UserRole();
		  userRole.setRole(role);
		  userRole.setUser(user);

		  userroleSet.add(userRole);
		  
		  User user1 = this.userService.createUser(user, userroleSet);
		  System.out.println(user1.getUsername());
		}catch (UserFoundException e) {
                e.printStackTrace();			
		}
	}

}
