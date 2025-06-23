package com.spidertech.libarySp.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spidertech.libarySp.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	
}
