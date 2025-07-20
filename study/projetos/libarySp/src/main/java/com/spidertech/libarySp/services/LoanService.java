package com.spidertech.libarySp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spidertech.libarySp.dtos.LoanDto;
import com.spidertech.libarySp.repositores.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository repository;
	
	public List<LoanDto> findAll() {
		return repository.findAll().stream().map(LoanDto::new).toList();
	}
	
	public boolean existsByBookId(Long id) {

		return repository.existsByBookId(id);
	};
	
	
	
}
