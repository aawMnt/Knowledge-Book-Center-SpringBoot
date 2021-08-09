package com.ecom.controler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.helper.UserFoundException;
import com.ecom.model.Role;
import com.ecom.model.User;
import com.ecom.model.UserRole;
import com.ecom.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("user")
public class UserControler {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	
	//for adminuser
	@PostMapping("/adminPost")
	public User saveAdmin(@RequestBody User user) throws Exception {
		
		//encoding password with bcrypt
		
		user.setPassword(bCrypt.encode(user.getPassword()));
		
		Set<UserRole> roles =  new HashSet<>();
		Role role = new Role();
		
		role.setRoleId(01L);
		role.setRoleName("ADMIN");
       
		UserRole userrole = new UserRole();
		userrole.setUser(user);
		userrole.setRole(role);
		
		roles.add(userrole);
		
		return userservice.createUser(user, roles);
		
	}
	
	//for normal user
	@PostMapping("/userPost")
	public User saveUser(@RequestBody User user) throws Exception {
		
		Set<UserRole> roles =  new HashSet<>();
		Role role = new Role();
		
		role.setRoleId(02L);
		role.setRoleName("NORMAL");
       
		UserRole userrole = new UserRole();
		userrole.setUser(user);
		userrole.setRole(role);
		
		roles.add(userrole);
		
		return userservice.createUser(user, roles);
		
	}

	//get all user
	@GetMapping("/allUsers")
	public List<User> getall() {
		return userservice.getAll();
	}
	
	//get by name
	@GetMapping("/{name}")
	public User getbyname(@PathVariable("name") String username) {
		
		return userservice.findbyname(username);
	}
	
	//update 
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") Long id) {
		return userservice.update(user, id);
	}
	
	
	//delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
	 userservice.delete(id);
	}
	
	
	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?> exeptionHandlaer (UserFoundException ex){
		return ResponseEntity.ok().build();
	}

}
