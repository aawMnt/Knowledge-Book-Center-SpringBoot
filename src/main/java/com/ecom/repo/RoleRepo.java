package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
