package com.spidertech.libarySp.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spidertech.libarySp.entities.logs.LoanLog;
import com.spidertech.libarySp.services.LoanLogService;

@RestController
@RequestMapping(value = "/loans/logs")
public class LoanLogResource {
		
	private final LoanLogService service;
	
	public LoanLogResource(LoanLogService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<LoanLog>> findAll(){
		List<LoanLog> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}

