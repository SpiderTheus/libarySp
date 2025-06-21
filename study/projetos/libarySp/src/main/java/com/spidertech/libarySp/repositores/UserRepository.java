package com.spidertech.libarySp.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spidertech.libarySp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAll();
	
}
