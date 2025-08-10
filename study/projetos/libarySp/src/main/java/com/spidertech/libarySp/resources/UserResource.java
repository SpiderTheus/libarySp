package com.spidertech.libarySp.resources;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spidertech.libarySp.dtos.LoanDto;
import com.spidertech.libarySp.dtos.UserDto;
import com.spidertech.libarySp.entities.User;
import com.spidertech.libarySp.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private final UserService service;

	public UserResource(UserService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {
		List<UserDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable Long id) {
		var obj = new UserDto();
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/{id}/loans")
	public ResponseEntity<Set<LoanDto>> loansUser(@PathVariable Long id) {
		Set<LoanDto> list = service.loansUser(id);
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<User> isert(@RequestBody User obj) {
		obj = service.isert(obj);
		return ResponseEntity.ok(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

}
