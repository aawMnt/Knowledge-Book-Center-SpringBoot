package com.ecom.controler;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.config.JwtUtils;
import com.ecom.helper.UserNotFoundException;
import com.ecom.model.JwtRequest;
import com.ecom.model.JwtRespons;
import com.ecom.model.User;
import com.ecom.serviceImpl.UserSecurityImpl;


@RestController
@CrossOrigin(origins = "*")
public class AuthControler {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	
	private UserSecurityImpl userSecutiry;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	

	@PostMapping("/generate-token") 
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwt) throws Exception{
		
		try {
			
			authentication(jwt.getUsername(),jwt.getPassword());
			
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");
		}
		
		////uthnticated
		
		UserDetails userDetail = this.userSecutiry.loadUserByUsername(jwt.getUsername());
		String token = this.jwtUtils.generateToken(userDetail);
		return ResponseEntity.ok(new JwtRespons(token));
	}
	
	
	
	
	private void authentication (String username,String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		}catch (DisabledException e ) {
			throw new Exception("User Disabled"+ e.getMessage());
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid Credition" + e.getMessage());
		}
	}
	
	@GetMapping("/current-user")
          public User getCurrentUser(Principal principal) {
		
		   return ( (User)userSecutiry.loadUserByUsername(principal.getName()));
		
	}
	
	
	
	
	
	
	
	
	
}
