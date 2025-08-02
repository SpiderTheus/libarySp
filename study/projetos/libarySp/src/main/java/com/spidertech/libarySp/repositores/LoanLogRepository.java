package com.spidertech.libarySp.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spidertech.libarySp.entities.logs.LoanLog;

public interface LoanLogRepository extends JpaRepository<LoanLog, Long> {
	
}
