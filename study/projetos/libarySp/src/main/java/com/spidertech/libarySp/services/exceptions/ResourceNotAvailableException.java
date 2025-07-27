package com.spidertech.libarySp.services.exceptions;

public class ResourceNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public ResourceNotAvailableException(String resource) {
		super(resource+ ", not Available.");
	}
}
