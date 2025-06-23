package com.spidertech.libarySp.services;


import java.util.List;

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

}
