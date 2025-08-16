package com.spidertech.libarySp.entities.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spidertech.libarySp.services.AuthorService;
import com.spidertech.libarySp.services.CategoryService;
import com.spidertech.libarySp.services.PublisherService;

@Component
public class BookBuilderFactory {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PublisherService publisherService;

	public BookBuilder create() {
		return new BookBuilder(authorService, categoryService, publisherService);
	}
}
