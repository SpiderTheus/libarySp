package com.spidertech.libarySp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spidertech.libarySp.entities.Author;
import com.spidertech.libarySp.repositores.AuthorRepository;
import com.spidertech.libarySp.services.exceptions.ResourceNotFoundException;

@Service
public class AuthorService {

	private final AuthorRepository repository;

	public AuthorService(AuthorRepository repository) {

		this.repository = repository;
	}

	public List<Author> findAll() {
		return repository.findAll();

	}

	public Author findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id, "Author not found"));
	
	}
	public Author isert(Author obj) {
		return repository.save(obj);
	}

	public Author update(Long id, Author obj) {
		Author entity = repository.getReferenceById(id);
		entity.setName(obj.getName());
		entity.setBirth(obj.getBirth());
		entity.setLocation(obj.getLocation());
		return repository.save(entity);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
