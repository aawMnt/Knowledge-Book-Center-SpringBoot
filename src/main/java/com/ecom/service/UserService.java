package com.ecom.service;

import java.util.List;
import java.util.Set;

import com.ecom.model.User;
import com.ecom.model.UserRole;

public interface UserService {
	
	//save user
	public User createUser(User user,Set<UserRole> userrole ) throws Exception;

   //	get all users
	
	public List<User> getAll();
	
	
	// find by name
	
	public User findbyname(String username);
	
	//delete
	
	public void delete(Long id);
	
	//update
	
	public User update (User user , Long id);
}
