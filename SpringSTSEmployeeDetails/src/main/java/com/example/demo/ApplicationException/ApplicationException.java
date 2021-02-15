package com.example.demo.ApplicationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApplicationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	

	


	public ApplicationException(String message) {
		
		super(message);
		this.message=message;
		
	}

	

}
