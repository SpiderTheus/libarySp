package com.spidertech.libarySp.services;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spidertech.libarySp.dtos.LoanDto;
import com.spidertech.libarySp.dtos.UserDto;
import com.spidertech.libarySp.entities.User;
import com.spidertech.libarySp.repositores.UserRepository;
import com.spidertech.libarySp.services.exceptions.NameNotNullException;
import com.spidertech.libarySp.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<UserDto> findAll() {
		
		return repository.findAll().stream().map(UserDto::new).toList();
		
	}
	
	public UserDto findById(Long id) {
		
		return new UserDto(repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id)));
		 
	}
	
	public User isert(User obj) {
		
		if(obj.getName() != null)return repository.save(obj);
		else throw new NameNotNullException();
		
		  
		
		
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
	
	public Set<LoanDto> loansUser(Long id){
		return findById(id).getLoans();
	}
}
