package com.spidertech.libarySp.dtos;

import java.time.Instant;

import com.spidertech.libarySp.entities.Loan;
import com.spidertech.libarySp.entities.enums.LoanStatus;



public class LoanDto {
	private long id;
	private long idBook;
	private String book;
	private Instant date;
	private LoanStatus status;
	
	public LoanDto(Loan loan) {
		this.id = loan.getId();
		this.setIdBook(loan.getBook().getId());
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
