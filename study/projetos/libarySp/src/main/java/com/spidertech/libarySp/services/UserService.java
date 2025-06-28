package com.spidertech.libarySp.services;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spidertech.libarySp.entities.Loan;
import com.spidertech.libarySp.entities.User;
import com.spidertech.libarySp.repositores.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User isert(User obj) {
		return repository.save(obj);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	public void updateData(User entity, User obj) {
		entity.updateFrom(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}	
	
	public Set<Loan> loansUser(Long id){
		return findById(id).getLoans();
	}
}
