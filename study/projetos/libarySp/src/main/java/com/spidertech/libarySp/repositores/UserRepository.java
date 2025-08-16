package com.spidertech.libarySp.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spidertech.libarySp.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
}
