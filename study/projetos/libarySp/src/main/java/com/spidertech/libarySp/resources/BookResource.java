package com.spidertech.libarySp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spidertech.libarySp.dtos.BookBuilderDto;
import com.spidertech.libarySp.dtos.BookDto;
import com.spidertech.libarySp.entities.Book;
import com.spidertech.libarySp.entities.builders.BookBuilder;
import com.spidertech.libarySp.services.AuthorService;
import com.spidertech.libarySp.services.BookService;
import com.spidertech.libarySp.services.CategoryService;
import com.spidertech.libarySp.services.PublisherService;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

	@Autowired
	private BookService service;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PublisherService publisherService;

	@GetMapping
	public ResponseEntity<List<BookDto>> findAll() {
		List<BookDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{title}")
	public ResponseEntity<List<BookDto>> findByName(@PathVariable String title) {

		title = title.replace("-", " ");
		System.out.println(title);
		List<BookDto> list = service.findByName(title);
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Book> isert(@RequestBody BookBuilderDto obj) {

		Book book = new BookBuilder(authorService, categoryService, publisherService).title(obj.getTitle())
				.authores(obj.getIdAuthors()).datePublisher(obj.getDatePublisher()).isAvalible(obj.isAvalible())
				.categories(obj.getNameCategory()).publisher(obj.getIdPublisher()).build();

		service.insert(book);

		return ResponseEntity.ok(book);

	}

}
