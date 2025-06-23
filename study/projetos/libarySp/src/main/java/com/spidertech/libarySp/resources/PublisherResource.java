package com.spidertech.libarySp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spidertech.libarySp.entities.Publisher;
import com.spidertech.libarySp.services.PublisherService;


@RestController
@RequestMapping(value = "/publishers")
public class PublisherResource {
	
	@Autowired
	private PublisherService service;
	
	@GetMapping
	public ResponseEntity<List<Publisher>> findAll(){
		List<Publisher> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
