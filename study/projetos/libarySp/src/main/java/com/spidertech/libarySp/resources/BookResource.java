package com.spidertech.libarySp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spidertech.libarySp.dtos.BookDto;
import com.spidertech.libarySp.services.BookService;


@RestController
@RequestMapping(value = "/books")
public class BookResource {
	
	@Autowired
	private BookService service;
	
	@GetMapping
	public ResponseEntity<List<BookDto>> findAll(){
		List<BookDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
