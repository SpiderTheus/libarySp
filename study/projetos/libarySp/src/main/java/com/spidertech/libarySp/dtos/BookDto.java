package com.spidertech.libarySp.dtos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.spidertech.libarySp.entities.Book;

public class BookDto {
	
	private Long id;
	private String title;
	private Set<Long> idAuthors = new HashSet<>();
	private Set<String> authores = new HashSet<>();
	private LocalDate datePublisher;
	private boolean isAvalible;
	private Set<Long> idCategories = new HashSet<>();
	private Set<String> categories = new HashSet<>();
	private String publisher;
	
	public BookDto() {
		
	}
	
	public BookDto(Book book) {
		BeanUtils.copyProperties(book, this);
		this.idAuthors = 	book.getAuthores().stream().map(a -> a.getId()).collect(Collectors.toSet());
		this.authores =	book.getAuthores().stream().map(a -> a.getName()).collect(Collectors.toSet());
		
		this.idCategories = book.getCategories().stream().map(a -> a.getId()).collect(Collectors.toSet());
		this.categories = book.getCategories().stream().map(a -> a.getName()).collect(Collectors.toSet());
	
		this.publisher = book.getPublisher().getName();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<String> getAuthores() {
		return authores;
	}

	public void setAuthores(Set<String> authores) {
		this.authores = authores;
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

	public Set<String> getCategories() {
		return categories;
	}

	public void setCategories(Set<String> categories) {
		this.categories = categories;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Set<Long> getIdCategories() {
		return idCategories;
	}

	public void setIdCategories(Set<Long> idCategories) {
		this.idCategories = idCategories;
	}

	public Set<Long> getIdAuthors() {
		return idAuthors;
	}

	public void setIdAuthors(Set<Long> idAuthors) {
		this.idAuthors = idAuthors;
	}
	
	
	
}
