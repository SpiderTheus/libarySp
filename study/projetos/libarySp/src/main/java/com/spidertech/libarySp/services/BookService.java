package com.spidertech.libarySp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spidertech.libarySp.entities.Book;
import com.spidertech.libarySp.repositores.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public List<Book> findAll() {
		return repository.findAll();
	}
	
}
