package com.ecom.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ecom.model.CustomerInfo;
import com.ecom.repo.CustRepo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/purches")
public class EcomPurchesContrroler {
	
	@Autowired
	private CustRepo repo;
	
     @PostMapping("/buy")
     public CustomerInfo info(@RequestBody CustomerInfo custInfo)
     {
    	
    	 return repo.save(custInfo);
    	 
     }
     
     @GetMapping("/getInfo")
     public List<CustomerInfo> getInfo() {

    	 return repo.findAll();
     }
     
     @DeleteMapping("deleteOrder/{id}")
     public void delete(@PathVariable("id") Long id) {
    	 repo.deleteById(id);
     }
     
     @GetMapping("/getById/{id}")
    public CustomerInfo getbyId(@PathVariable("id") Long id) {
    	 return repo.getById(id);
     }
}
