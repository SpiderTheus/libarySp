package com.spidertech.libarySp.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spidertech.libarySp.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
	
	boolean existsByBookId(Long id);
}
