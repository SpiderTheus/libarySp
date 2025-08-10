package com.spidertech.libarySp.services;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spidertech.libarySp.entities.Category;
import com.spidertech.libarySp.repositores.CategoryRepository;
import com.spidertech.libarySp.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

	private final CategoryRepository repository;
	
	public CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Long id) {

		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id, "Category not found."));
	}

	public Set<Category> insertByNamesContaining(Collection<String> categories){
		
		return repository.findAll()
				.stream().filter(c -> categories.contains(c.getName()))
				.collect(Collectors.toSet());
		
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
