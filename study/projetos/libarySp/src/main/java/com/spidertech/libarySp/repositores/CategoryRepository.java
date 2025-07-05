package com.spidertech.libarySp.repositores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spidertech.libarySp.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	
	Optional<Category> findByNameContainingIgnoreCase(String name);
}
