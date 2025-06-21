package com.spidertech.libarySp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spidertech.libarySp.entities.User;
import com.spidertech.libarySp.repositores.UserRepository;


@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}
}
