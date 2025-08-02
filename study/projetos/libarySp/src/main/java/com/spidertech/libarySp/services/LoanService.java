package com.spidertech.libarySp.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spidertech.libarySp.dtos.LoanDto;
import com.spidertech.libarySp.entities.Loan;
import com.spidertech.libarySp.entities.logs.LoanLog;
import com.spidertech.libarySp.repositores.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository repository;
	
	@Autowired
	private LoanLogService logService;
	
	public List<LoanDto> findAll() {
		return repository.findAll().stream().map(LoanDto::new).toList();
	}
	
	
	public boolean existsByBookId(Long id) {

		return repository.existsByBookId(id);
	};
	
	public Loan isert(Loan obj) {
		return repository.save(obj);
	}

	public Optional<Loan> findById(Long id) {

		return repository.findById(id);
	}
	
	public void delete(Loan loan) {
		LoanLog log = new LoanLog(new LoanDto(loan));
		
		
		logService.isert(log);
		repository.delete(loan);
		
		
	}
}
