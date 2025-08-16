package com.spidertech.libarySp.entities.builders;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.spidertech.libarySp.entities.Author;
import com.spidertech.libarySp.entities.Book;
import com.spidertech.libarySp.entities.Category;
import com.spidertech.libarySp.entities.Publisher;
import com.spidertech.libarySp.services.AuthorService;
import com.spidertech.libarySp.services.CategoryService;
import com.spidertech.libarySp.services.PublisherService;

public class BookBuilder {
	
	
	private AuthorService authorService;
	private CategoryService categoryService;
	private PublisherService publisherService;

	private String title;
	private Set<Author> authores = new HashSet<>();
	private LocalDate datePublisher;
	private boolean isAvalible;
	private Set<Category> categories = new HashSet<>();
	private Publisher publisher;

	public BookBuilder(AuthorService authorService, CategoryService categoryService,
			PublisherService publisherService) {
		this.authorService = authorService;
		this.categoryService = categoryService;
		this.publisherService = publisherService;

	}

	public BookBuilder title(String title) {
		this.title = title;
		return this;
	}

	public BookBuilder authores(Set<Long> idAuthors) {
		this.authores = idAuthors.stream().map(i -> authorService.findById(i)).collect(Collectors.toSet());
		return this;
	}

	public BookBuilder datePublisher(LocalDate datePublisher) {
		this.datePublisher = datePublisher;
		return this;
	}

	public BookBuilder isAvalible(boolean isAvalible) {
		this.isAvalible = isAvalible;
		return this;
	}

	public BookBuilder categories(Set<String> categories) {

		this.categories = categoryService.insertByNamesContaining(categories);

		return this;
	}

	public BookBuilder publisher(String publisher) {
		this.publisher = publisherService.findByName(publisher);
		return this;
	}

	public Book build() {
		return new Book(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Author> getAuthores() {
		return new HashSet<>(this.authores);
	}

	public LocalDate getDatePublisher() {
		return datePublisher;
	}

	public void setDatePublisher(LocalDate datePublisher) {
		this.datePublisher = datePublisher;
	}

	public boolean isAvalible() {
		return isAvalible;
	}

	public void setAvalible(boolean isAvalible) {
		this.isAvalible = isAvalible;
	}

	public Set<Category> getCategories() {
		return new HashSet<>(this.categories);
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

}
