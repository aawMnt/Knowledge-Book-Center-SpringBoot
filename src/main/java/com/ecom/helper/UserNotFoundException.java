package com.ecom.helper;

public class UserNotFoundException  extends Exception{
	
	public UserNotFoundException() {
		super("User Not Found in the Data base");
	}
	
	public UserNotFoundException(String msg) {super(msg);}

}
