package com.spidertech.libarySp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spidertech.libarySp.entities.logs.LoanLog;
import com.spidertech.libarySp.repositores.LoanLogRepository;

@Service
public class LoanLogService {

	public final LoanLogRepository repository;

	public LoanLogService(LoanLogRepository repository) {

		this.repository = repository;
	}

	public List<LoanLog> findAll() {
		return repository.findAll();
	}

	public LoanLog isert(LoanLog obj) {
		return repository.save(obj);
	}

}
