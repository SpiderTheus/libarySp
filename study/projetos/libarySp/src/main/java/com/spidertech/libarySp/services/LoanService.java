package com.spidertech.libarySp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spidertech.libarySp.entities.Loan;
import com.spidertech.libarySp.repositores.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository repository;
	
	public List<Loan> findAll() {
		return repository.findAll();
	}
	
}
