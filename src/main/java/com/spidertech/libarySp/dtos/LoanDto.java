package com.spidertech.libarySp.dtos;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spidertech.libarySp.entities.Loan;
import com.spidertech.libarySp.entities.enums.LoanStatus;

public class LoanDto {
	private long id;
	private long idBook;
	private String user;
	private String book;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant date;
	private LoanStatus status;

	public LoanDto(Loan loan) {
		this.id = loan.getId();
		this.idBook = loan.getBook().getId();
		this.user = loan.getUser().getName();
		this.book = loan.getBook().getTitle();
		this.date = loan.getDate();
		this.status = loan.getStatus();
	}

	public LoanDto() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public LoanStatus getStatus() {
		return status;
	}

	public void setStatus(LoanStatus status) {
		this.status = status;
	}

	public long getIdBook() {
		return idBook;
	}

	public void setIdBook(long idBook) {
		this.idBook = idBook;
	}

}
