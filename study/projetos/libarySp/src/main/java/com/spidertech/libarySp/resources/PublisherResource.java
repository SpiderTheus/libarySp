package com.spidertech.libarySp.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spidertech.libarySp.entities.Publisher;
import com.spidertech.libarySp.services.PublisherService;


@RestController
@RequestMapping(value = "/publishers")
public class PublisherResource {
	
	private final PublisherService service;
	
	public PublisherResource(PublisherService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Publisher>> findAll(){
		List<Publisher> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Publisher> findById(@PathVariable Long id) {
		Publisher obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Publisher> isert(@RequestBody Publisher obj) {
		obj = service.isert(obj);
		return ResponseEntity.ok(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Publisher> update(@PathVariable Long id, @RequestBody Publisher obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
