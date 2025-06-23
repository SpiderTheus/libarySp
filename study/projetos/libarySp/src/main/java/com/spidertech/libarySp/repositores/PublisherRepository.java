package com.spidertech.libarySp.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spidertech.libarySp.entities.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
	
}
