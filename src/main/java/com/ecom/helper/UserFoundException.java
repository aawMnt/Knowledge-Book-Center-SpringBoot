package com.ecom.helper;

public class UserFoundException extends Exception {
	
	public UserFoundException() {
		super("user with this name is alrady in Data Base !!! try with  other user name");
	}
	
	public UserFoundException(String msg) {super(msg);}

}
