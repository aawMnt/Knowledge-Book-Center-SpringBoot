package com.ecom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ecom.serviceImpl.UserSecurityImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserSecurityImpl userSecurityImpl;
	
	@Autowired
	private JwtAuthEntryPoint authEntryPoint;
	
	
	@Autowired
	
	private JwtAuthFilter filter;

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		
		return super.authenticationManager();
	}
	
	@Bean
	  public BCryptPasswordEncoder passwordEncod() {
		  
		  return  new BCryptPasswordEncoder();
	  }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userSecurityImpl).passwordEncoder(passwordEncod());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		
	     .csrf()
	     .disable()
	     .cors()
	     .disable()
	     .authorizeRequests()
	     .antMatchers("/generate-token","/user/userPost","/books/get","/product/pro",
	    		 "/books/findby/{id}","/purches/buy").permitAll()
	     .antMatchers(HttpMethod.OPTIONS).permitAll()
	     .anyRequest().authenticated()
	     .and()
	     .exceptionHandling().authenticationEntryPoint(authEntryPoint)
	     .and()
	     .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}

	
	
	
	

}
