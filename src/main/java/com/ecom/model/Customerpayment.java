package com.ecom.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Customerpayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pId;
	private String cardName;
	private String cardNo;
	@Temporal(TemporalType.DATE)
	private Date expiryDate;
	private String cvvNo;
	private String cardType;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date currentUtilDate = new Date(System.currentTimeMillis());

	
	
	public Customerpayment() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Customerpayment(Long pId, String cardName, String cardNo, Date expiryDate, String cvvNo, String cardType,
			Date currentUtilDate) {
		super();
		this.pId = pId;
		this.cardName = cardName;
		this.cardNo = cardNo;
		this.expiryDate = expiryDate;
		this.cvvNo = cvvNo;
		this.cardType = cardType;
		this.currentUtilDate = currentUtilDate;
	}



	public Long getpId() {
		return pId;
	}



	public void setpId(Long pId) {
		this.pId = pId;
	}



	public String getCardName() {
		return cardName;
	}



	public void setCardName(String cardName) {
		this.cardName = cardName;
	}



	public String getCardNo() {
		return cardNo;
	}



	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}



	public Date getExpiryDate() {
		return expiryDate;
	}



	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}



	public String getCvvNo() {
		return cvvNo;
	}



	public void setCvvNo(String cvvNo) {
		this.cvvNo = cvvNo;
	}



	public String getCardType() {
		return cardType;
	}



	public void setCardType(String cardType) {
		this.cardType = cardType;
	}



	public Date getCurrentUtilDate() {
		return currentUtilDate;
	}



	public void setCurrentUtilDate(Date currentUtilDate) {
		this.currentUtilDate = currentUtilDate;
	}





	
	
	
}
 