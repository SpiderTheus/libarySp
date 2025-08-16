package com.spidertech.libarySp.dtos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.spidertech.libarySp.entities.Author;
import com.spidertech.libarySp.entities.Book;

public class BookDto {

	private String title;
	private Set<Long> idAuthors = new HashSet<>();
	private Set<String> authores = new HashSet<>();
	private LocalDate datePublisher;
	private boolean isAvalible;
	private Set<String> categories = new HashSet<>();
	private String publisher;

	public BookDto() {

	}

	public BookDto(Book book) {
		BeanUtils.copyProperties(book, this);
		this.idAuthors = book.getAuthores().stream().map(Author::getId).collect(Collectors.toSet());
		this.authores = book.getAuthores().stream().map(Author::getName).collect(Collectors.toSet());
		this.categories = book.getCategories().stream().map(a -> a.getName()).collect(Collectors.toSet());
		this.publisher = book.getPublisher().getName();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<String> getAuthores() {
		return new HashSet<>(authores);
	}

	public void setAuthores(Set<String> authores) {
		this.authores =	new HashSet<>(authores);
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
		return new HashSet<>(categories);
	}

	public void setCategories(Set<String> categories) {
		this.categories = new HashSet<>(categories);
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Set<Long> getIdAuthors() {
		return new HashSet<>(idAuthors);
	}

	public void setIdAuthors(Set<Long> idAuthors) {
		this.idAuthors = new HashSet<>(idAuthors);
	}

}
