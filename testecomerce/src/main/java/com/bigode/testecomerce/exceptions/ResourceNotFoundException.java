package com.bigode.testecomerce.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object obj){
	        super("Resource not found. Id: " + obj);
	    }
}
