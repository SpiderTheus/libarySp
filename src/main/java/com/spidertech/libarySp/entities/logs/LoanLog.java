package com.spidertech.libarySp.entities.logs;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spidertech.libarySp.dtos.LoanDto;
import com.spidertech.libarySp.entities.enums.LoanStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_loan_log")
public class LoanLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long idBook;
	private String userBorrower;
	private String book;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant date;
	private LoanStatus status;

	public LoanLog() {

	}

	public LoanLog(LoanDto loan) {
		BeanUtils.copyProperties(loan, this);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdBook() {
		return idBook;
	}

	public void setIdBook(long idBook) {
		this.idBook = idBook;
	}

	public String getUser() {
		return userBorrower;
	}

	public void setUser(String userBorrowerBorrower) {
		this.userBorrower = userBorrowerBorrower;
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

}
