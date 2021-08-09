package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.CustomerInfo;

public interface CustRepo extends JpaRepository<CustomerInfo, Long> {

}
