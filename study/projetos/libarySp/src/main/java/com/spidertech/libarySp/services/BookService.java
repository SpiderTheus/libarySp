package com.spidertech.libarySp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spidertech.libarySp.dtos.BookDto;
import com.spidertech.libarySp.entities.Book;
import com.spidertech.libarySp.repositores.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	

	
	public List<BookDto> findAll() {
		return repository.findAll().stream().map(BookDto::new).toList();
	}
	
	public List<BookDto> findByName(String title) {
		return repository.findByTitleContainingIgnoreCase(title).stream().map(BookDto::new).toList();
	}
	
	public Book insert(Book obj) {
		return repository.save(obj);
	}
	
	
	
}
