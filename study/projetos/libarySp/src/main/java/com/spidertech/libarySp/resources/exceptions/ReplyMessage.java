package com.spidertech.libarySp.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReplyMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private transient Instant timeInstant;
	private Integer status;
	private String message;
	
	public ReplyMessage() {
		
	}

	public ReplyMessage(Instant timeInstant, Integer status, String message) {
		super();
		this.timeInstant = timeInstant;
		this.status = status;
		this.message = message;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	
}
