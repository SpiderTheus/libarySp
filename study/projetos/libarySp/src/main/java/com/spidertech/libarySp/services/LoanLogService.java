package com.spidertech.libarySp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spidertech.libarySp.entities.logs.LoanLog;
import com.spidertech.libarySp.repositores.LoanLogRepository;

@Service
public class LoanLogService {
	
	@Autowired
	LoanLogRepository repository;
	
	public List<LoanLog> findAll() {
		return repository.findAll();
	}
	
	
	public LoanLog isert(LoanLog obj) {
		return repository.save(obj);
	}
	
	
}
