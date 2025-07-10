package com.spidertech.libarySp.repositores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spidertech.libarySp.entities.Publisher;


public interface PublisherRepository extends JpaRepository<Publisher, Long> {
	
	Optional<Publisher> findByName(String name);
}
