package com.spidertech.libarySp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spidertech.libarySp.entities.Loan;
import com.spidertech.libarySp.services.LoanService;

@RestController
@RequestMapping(value = "/loans")
public class LoanResource {
		
	@Autowired
	private LoanService service;
	
	@GetMapping
	public ResponseEntity<List<Loan>> findAll(){
		List<Loan> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
