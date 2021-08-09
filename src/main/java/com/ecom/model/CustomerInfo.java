package com.ecom.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CustomerInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cId;
	private String firstname;
	private String lastname;
	private String email;
	private String phoneNo;
	private String address;
	private String city;
	private String pin;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate = new Date();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cId",referencedColumnName = "cId")
	private Customerpayment payment;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="cId", referencedColumnName = "cId")
	private List<CustomerOrder>product;

	public CustomerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerInfo(Long cId, String firstname, String lastname, String email, String phoneNo, String address,
			String city, String pin, Date orderDate, Customerpayment payment, List<CustomerOrder> product) {
		super();
		this.cId = cId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.city = city;
		this.pin = pin;
		this.orderDate = orderDate;
		this.payment = payment;
		this.product = product;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customerpayment getPayment() {
		return payment;
	}

	public void setPayment(Customerpayment payment) {
		this.payment = payment;
	}

	public List<CustomerOrder> getProduct() {
		return product;
	}

	public void setProduct(List<CustomerOrder> product) {
		this.product = product;
	}

	
	


	
	

	
	
	
}
