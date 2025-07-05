package com.spidertech.libarySp.entities.builders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.spidertech.libarySp.entities.Author;
import com.spidertech.libarySp.entities.Category;
import com.spidertech.libarySp.entities.Publisher;
import com.spidertech.libarySp.resources.AuthorResource;
import com.spidertech.libarySp.services.AuthorService;
import com.spidertech.libarySp.services.CategoryService;

public class BookBuilder {
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private CategoryService categoryService;
	
	private String title;
	private Set<Author> authores = new HashSet<>();
	private LocalDate datePublisher;
	private boolean isAvalible;
	private Set<Category> categories = new HashSet<>();
	private Publisher publisher;
	
	public BookBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public BookBuilder authores(ArrayList<Long> idAuthors) {
		Set<Author> authors = idAuthors.stream().map(i -> authorService.findById(i)).collect(Collectors.toSet());
		this.authores = authors;
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
	
	public BookBuilder categories(String nameCategory) {
		
		
		
		return this;
	}
	
	
}
