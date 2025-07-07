package com.spidertech.libarySp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spidertech.libarySp.dtos.BookBuilderDto;
import com.spidertech.libarySp.dtos.BookDto;
import com.spidertech.libarySp.entities.Book;
import com.spidertech.libarySp.entities.builders.BookBuilder;
import com.spidertech.libarySp.repositores.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PublisherService publisherService;

	public List<BookDto> findAll() {
		return repository.findAll().stream().map(BookDto::new).toList();
	}
	
	
	public Optional<Book> findById(Long id) {
		return repository.findById(id);
	}

	public List<BookDto> findByName(String title) {
		return repository.findByTitleContainingIgnoreCase(title).stream().map(BookDto::new).toList();
	}

	public Book insert(BookBuilderDto obj) {
		
		Book book = new BookBuilder(authorService, categoryService, publisherService, obj).build();

		return repository.save(book);
	}

	/*public Book update(Long id, BookBuilderDto obj) {
		
		Book book = findById(id).get();		
		book.setTitle(obj.getTitle());
		
		
		
		
		
	}*/

}
