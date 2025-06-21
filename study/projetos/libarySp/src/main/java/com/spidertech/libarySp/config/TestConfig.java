package com.spidertech.libarySp.config;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.spidertech.libarySp.entities.User;
import com.spidertech.libarySp.repositores.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u1 = new User(null, "Matheus Moraes", "matheus@gmail.com", "77-98848-0213");
		User u2 = new User(null, "Lucas Silva", "lucas.silva@gmail.com", "77-98847-1234");
		User u3 = new User(null, "Ana Pereira", "ana.pereira@gmail.com", "77-98846-5678");
		User u4 = new User(null, "Carlos Eduardo", "carlos.edu@gmail.com", "77-98845-8765");
		User u5 = new User(null, "Fernanda Lima", "fernanda.lima@gmail.com", "77-98844-3456");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
		
	}
	
	
	
}
