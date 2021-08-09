package com.ecom.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecom.helper.UserFoundException;
import com.ecom.model.User;
import com.ecom.model.UserRole;
import com.ecom.repo.RoleRepo;
import com.ecom.repo.UserRepo;
import com.ecom.service.UserService;

@Service
public class UserServiceImpl implements UserService  {
	
	@Autowired
	private UserRepo repo;

	@Autowired
	private RoleRepo rolerepo;
	
	
	//save user
	@Override
	public User createUser(User user, Set<UserRole> userrole) throws Exception {
		
		User local = repo.findByUsername(user.getUsername());
		
		if(local !=null) {
			System.out.println("User is alredy there !!!!!");
			throw new UserFoundException();
		}else {
			for(UserRole ur:userrole) {
				rolerepo.save(ur.getRole());
			}
			user.getUserRoles().addAll(userrole);
			local = repo.save(user);
		}
		return local;
	}

	
	//get all users
	@Override
	public List<User> getAll( ) {
		
		return repo.findAll();
	}


  // find by name
	@Override
	public User findbyname(String username) {
		
		return repo.findByUsername(username);
	}


	@Override
	public void delete(Long id) {
		repo.deleteById(id);
		
	}


	@Override
	public User update(User user, Long id) {
		
		User u = repo.findById(id).get();
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setEmail(user.getEmail());
		
		return repo.save(u);
	}
	
	
	

}
