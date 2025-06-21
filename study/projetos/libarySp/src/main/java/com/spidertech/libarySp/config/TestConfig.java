package com.spidertech.libarySp.config;



import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.spidertech.libarySp.entities.Loan;
import com.spidertech.libarySp.entities.User;
import com.spidertech.libarySp.entities.enums.LoanStatus;
import com.spidertech.libarySp.repositores.LoanRepository;
import com.spidertech.libarySp.repositores.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoanRepository loanRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u1 = new User(null, "Matheus Moraes", "matheus@gmail.com", "77-98848-0213");
		User u2 = new User(null, "Lucas Silva", "lucas.silva@gmail.com", "77-98847-1234");
		User u3 = new User(null, "Ana Pereira", "ana.pereira@gmail.com", "77-98846-5678");
		User u4 = new User(null, "Carlos Eduardo", "carlos.edu@gmail.com", "77-98845-8765");
		User u5 = new User(null, "Fernanda Lima", "fernanda.lima@gmail.com", "77-98844-3456");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
		
		Loan l1 = new Loan(null, LoanStatus.ACTIVE, Instant.parse("2024-06-10T10:00:00Z"), u1);
		Loan l2 = new Loan(null, LoanStatus.LATE, Instant.parse("2024-06-12T14:30:00Z"), u2);
		Loan l3 = new Loan(null, LoanStatus.RETURNED, Instant.parse("2024-05-20T09:15:00Z"), u3);
		Loan l4 = new Loan(null, LoanStatus.LATE, Instant.parse("2024-06-01T11:00:00Z"), u4);
		Loan l5 = new Loan(null, LoanStatus.ACTIVE, Instant.parse("2024-06-05T16:45:00Z"), u5);
		Loan l6 = new Loan(null, LoanStatus.ACTIVE, Instant.parse("2024-06-15T08:00:00Z"), u1);

		loanRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6));
	}
	
	
	
}
