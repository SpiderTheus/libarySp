package com.spidertech.libarySp.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spidertech.libarySp.dtos.LoanDto;
import com.spidertech.libarySp.services.LoanService;

@RestController
@RequestMapping(value = "/loans")
public class LoanResource {

	private final LoanService service;
	
	public LoanResource(LoanService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<LoanDto>> findAll(){
		List<LoanDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
