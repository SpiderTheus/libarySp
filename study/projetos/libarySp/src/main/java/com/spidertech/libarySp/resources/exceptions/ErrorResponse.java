package com.spidertech.libarySp.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timeInstant;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public ErrorResponse() {
		
	}

	public ErrorResponse(Instant timeInstant, Integer status, String message, String error, String path) {
		super();
		this.timeInstant = timeInstant;
		this.status = status;
		this.message = message;
		this.error = error;
		this.path = path;
	}

	public Instant getTimeInstant() {
		return timeInstant;
	}

	public void setTimeInstant(Instant timeInstant) {
		this.timeInstant = timeInstant;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
