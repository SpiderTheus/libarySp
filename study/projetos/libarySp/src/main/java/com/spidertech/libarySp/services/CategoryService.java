package com.spidertech.libarySp.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spidertech.libarySp.entities.Category;
import com.spidertech.libarySp.repositores.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);

		return obj.get();
	}

	public Set<Category> insertByNamesContaining(Set<String> categories){
		
		
		Set<Category> nameCategories = repository.findAll().stream().filter(c -> categories.contains(c.getName())).collect(Collectors.toSet());
	
		
		
		return nameCategories;
		
	}

	public Category isert(Category obj) {
		return repository.save(obj);
	}

	public Category update(Long id, Category obj) {
		Category entity = repository.getReferenceById(id);
		entity.setName(obj.getName());
		return repository.save(entity);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
