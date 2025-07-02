package com.spidertech.libarySp.entities.builders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.spidertech.libarySp.entities.Author;
import com.spidertech.libarySp.entities.Category;

public class BookBuilder {
	
	
	
	private String title;
	private Set<Author> authores = new HashSet<>();
	private LocalDate datePublisher;
	private boolean isAvalible;
	private Set<Category> categories = new HashSet<>();
	private String publisher;
	
	public BookBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public BookBuilder authores(ArrayList<Long> id) {
		return this;
	}
	
}
