package com.spidertech.libarySp.services.exceptions;

public class ResourceNotDeleteAssociationsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotDeleteAssociationsException(String association) {
		super("Resource have associations with "+association);
	}

}
