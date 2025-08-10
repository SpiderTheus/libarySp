package com.spidertech.libarySp.services.exceptions;

public class NameNotNullException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NameNotNullException() {
		super("The Name cannot be null");
	}
	
}
