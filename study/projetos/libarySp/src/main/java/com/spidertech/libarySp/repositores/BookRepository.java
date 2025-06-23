package com.spidertech.libarySp.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spidertech.libarySp.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
}
