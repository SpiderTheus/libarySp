package com.spidertech.libarySp.services;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spidertech.libarySp.dtos.BookDto;
import com.spidertech.libarySp.entities.Book;
import com.spidertech.libarySp.entities.Loan;
import com.spidertech.libarySp.entities.User;
import com.spidertech.libarySp.entities.builders.BookBuilder;
import com.spidertech.libarySp.entities.enums.LoanStatus;
import com.spidertech.libarySp.repositores.BookRepository;
import com.spidertech.libarySp.services.exceptions.NoResultsFoundException;
import com.spidertech.libarySp.services.exceptions.ResourceNotAvailableException;
import com.spidertech.libarySp.services.exceptions.ResourceNotDeleteAssociationsException;
import com.spidertech.libarySp.services.exceptions.ResourceNotFoundException;

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
	
	@Autowired
	private UserService userService;
	

	@Autowired
	private LoanService loanService;

	public List<BookDto> findAll() {
		return repository.findAll().stream().map(BookDto::new).toList();
	}

	public Optional<Book> findById(Long id) {

		return repository.findById(id);
	}

	public List<BookDto> findByName(String title) {
	
		List<BookDto> books = repository.findByTitleContainingIgnoreCase(title).stream().map(BookDto::new).toList();
		if(books.isEmpty())
			throw new NoResultsFoundException(title);
		
		return books;
	}

	public Book insert(BookDto obj) {

		Book book = new BookBuilder(authorService, categoryService, publisherService, obj).build();

		return repository.save(book);
	}

	public Book update(Long id, BookDto obj) {
		Book bookUpdate = new BookBuilder(authorService, categoryService, publisherService, obj).build();
		try {
			Book book = findById(id).get();
			if (bookUpdate.getTitle() != null)
				book.setTitle(bookUpdate.getTitle());
			if (bookUpdate.getAuthores() != null)
				book.setAuthores(bookUpdate.getAuthores());
			if (bookUpdate.getDatePublisher() != null)
				book.setDatePublisher(bookUpdate.getDatePublisher());
			if (bookUpdate.isAvalible() != book.isAvalible())
				book.setAvalible(bookUpdate.isAvalible());
			if (bookUpdate.getCategories() != null)
				book.setCategories(bookUpdate.getCategories());
			if (bookUpdate.getPublisher() != null)
				book.setPublisher(bookUpdate.getPublisher());

			return repository.save(book);
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id, "Book not updated.");
		}

	}

	public void delete(Long id) {
		
		if(!repository.existsById(id))
			throw new ResourceNotFoundException(id, "Book not deleted");
		
		if (loanService.existsByBookId(id)) {
			throw new ResourceNotDeleteAssociationsException("Loans");
		} 
		
		repository.deleteById(id);
	}
	
	public Loan lendBook(Long bookId, Long userId) {
		
		Book book = findById(bookId).orElseThrow(()-> new ResourceNotFoundException(bookId, "Book not found for loan."));
		User user = userService.findById(userId);
			
		if(book.isAvalible()) {
			Loan loan = new Loan(LoanStatus.ACTIVE, Instant.now(), user, book);
			book.setAvalible(false);
			repository.save(book);
			return loanService.isert(loan);
		} else {
			throw new ResourceNotAvailableException(book.getTitle());
		}
	}
	
}
