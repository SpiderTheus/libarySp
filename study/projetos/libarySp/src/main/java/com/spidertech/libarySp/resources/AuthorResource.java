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

import com.spidertech.libarySp.entities.Author;
import com.spidertech.libarySp.services.AuthorService;


@RestController
@RequestMapping(value = "/authores")
public class AuthorResource {
	

	private final AuthorService service;
	
	public AuthorResource(AuthorService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Author>> findAll(){
		List<Author> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Author> findById(@PathVariable Long id) {
		Author obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Author> isert(@RequestBody Author obj) {
		obj = service.isert(obj);
		return ResponseEntity.ok(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody Author obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
