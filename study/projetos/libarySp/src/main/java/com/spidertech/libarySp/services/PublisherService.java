package com.spidertech.libarySp.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spidertech.libarySp.entities.Publisher;
import com.spidertech.libarySp.repositores.PublisherRepository;

@Service
public class PublisherService {
	
	@Autowired
	private PublisherRepository repository;
	
	public List<Publisher> findAll() {
		return repository.findAll();
	}
	
	public Publisher findById(Long id) {
		Optional<Publisher> obj = repository.findById(id);
		
		return obj.get();
	}
	
	public Publisher findByName(String name) {
		Optional<Publisher> obj = repository.findByName(name);
		
		return obj.get();
	}
	
	
	public Publisher isert(Publisher obj) {
		return repository.save(obj);
	}
	
	public Publisher update(Long id, Publisher obj) {
		Publisher entity = repository.getReferenceById(id);
		entity.setName(obj.getName());
		entity.setLocation(obj.getLocation());
		return repository.save(entity);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}	
}
