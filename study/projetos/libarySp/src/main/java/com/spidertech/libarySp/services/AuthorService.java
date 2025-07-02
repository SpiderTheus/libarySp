package com.spidertech.libarySp.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spidertech.libarySp.entities.Author;
import com.spidertech.libarySp.repositores.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository repository;
	
	public List<Author> findAll() {
		return repository.findAll();
		
	}
	
	public Author findById(Long id) {
		Optional<Author> obj = repository.findById(id);
		
		return obj.get();
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
