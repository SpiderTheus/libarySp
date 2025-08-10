package com.spidertech.libarySp.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spidertech.libarySp.dtos.BookDto;
import com.spidertech.libarySp.dtos.LoanDto;
import com.spidertech.libarySp.entities.Book;
import com.spidertech.libarySp.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

	private final BookService service;

	public BookResource(BookService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<BookDto>> findAll() {
		List<BookDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{title}")
	public ResponseEntity<List<BookDto>> findByName(@PathVariable String title) {
		title = title.replace("-", " ");
		List<BookDto> list = service.findByName(title);
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Book> isert(@RequestBody BookDto obj) {
		var book = service.insert(obj);
		return ResponseEntity.ok(book);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<BookDto> update(@PathVariable Long id, @RequestBody BookDto obj) {
		obj = new BookDto(service.update(id, obj));
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/loan:/{bookId}/user/{userId}")
	public ResponseEntity<LoanDto> loanBooK(@PathVariable Long bookId, @PathVariable Long userId) {
		var loan = new LoanDto(service.lendBook(bookId, userId));
		return ResponseEntity.ok(loan);
	}

	@PutMapping(value = "returnBook/{loanId}")
	public ResponseEntity<BookDto> returnBook(@PathVariable Long loanId) {
		var obj = new BookDto(service.returnBook(loanId));
		return ResponseEntity.ok().body(obj);
	}

}
