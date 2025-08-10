package com.spidertech.libarySp.services;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spidertech.libarySp.dtos.BookDto;
import com.spidertech.libarySp.entities.Book;
import com.spidertech.libarySp.entities.Loan;
import com.spidertech.libarySp.entities.builders.BookBuilder;
import com.spidertech.libarySp.entities.enums.LoanStatus;
import com.spidertech.libarySp.repositores.BookRepository;
import com.spidertech.libarySp.services.exceptions.NoResultsFoundException;
import com.spidertech.libarySp.services.exceptions.ResourceNotAvailableException;
import com.spidertech.libarySp.services.exceptions.ResourceNotDeleteAssociationsException;
import com.spidertech.libarySp.services.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class BookService {

	private final BookRepository repository;
	private final AuthorService authorService;
	private final CategoryService categoryService;
	private final PublisherService publisherService;
	private final UserService userService;
	private final LoanService loanService;

	public BookService(BookRepository repository, AuthorService authorService, CategoryService categoryService,
			PublisherService publisherService, UserService userService, LoanService loanService) {
		super();
		this.repository = repository;
		this.authorService = authorService;
		this.categoryService = categoryService;
		this.publisherService = publisherService;
		this.userService = userService;
		this.loanService = loanService;
	}

	public List<BookDto> findAll() {
		return repository.findAll().stream().map(BookDto::new).toList();
	}

	public Book findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, "Book not found."));
	}

	public List<BookDto> findByName(String title) {
		List<BookDto> books = repository.findByTitleContainingIgnoreCase(title).stream().map(BookDto::new).toList();
		if (books.isEmpty())
			throw new NoResultsFoundException(title);

		return books;
	}

	public Book insert(BookDto obj) {

		var book = new BookBuilder(authorService, categoryService, publisherService).title(obj.getTitle())
				.authores(obj.getIdAuthors()).datePublisher(obj.getDatePublisher()).isAvalible(obj.isAvalible())
				.categories(obj.getCategories()).publisher(obj.getPublisher()).build();

		return repository.save(book);
	}

	public Book update(Long id, BookDto obj) {

		var bookUpdate = new BookBuilder(authorService, categoryService, publisherService).title(obj.getTitle())
				.authores(obj.getIdAuthors()).datePublisher(obj.getDatePublisher()).isAvalible(obj.isAvalible())
				.categories(obj.getCategories()).publisher(obj.getPublisher()).build();

		var book = findById(id);
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

	}

	public void delete(Long id) {

		if (!repository.existsById(id))
			throw new ResourceNotFoundException(id, "Book not deleted");

		if (loanService.existsByBookId(id)) {
			throw new ResourceNotDeleteAssociationsException("Loans");
		}

		repository.deleteById(id);
	}

	@Transactional
	public Loan lendBook(Long bookId, Long userId) {

		var book = findById(bookId);
		var user = userService.findById(userId);

		if (book.isAvalible()) {
			var loan = new Loan(LoanStatus.ACTIVE, Instant.now(), user, book);
			book.setAvalible(false);
			repository.save(book);
			return loanService.isert(loan);
		}

		throw new ResourceNotAvailableException(book.getTitle());
	}

	@Transactional
	public Book returnBook(Long loanId) {
		Loan loan = loanService.findById(loanId)
				.orElseThrow(() -> new ResourceNotFoundException(loanId, ": Loan not found."));
		var book = loan.getBook();

		loan.setDate(Instant.now());
		loan.setStatus(LoanStatus.RETURNED);
		book.setAvalible(true);

		repository.save(book);

		loanService.delete(loan);

		return book;
	}

}
