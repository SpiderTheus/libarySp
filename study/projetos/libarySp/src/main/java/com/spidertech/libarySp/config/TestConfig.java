package com.spidertech.libarySp.config;



import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.spidertech.libarySp.entities.Book;
import com.spidertech.libarySp.entities.Loan;
import com.spidertech.libarySp.entities.User;
import com.spidertech.libarySp.entities.enums.LoanStatus;
import com.spidertech.libarySp.repositores.BookRepository;
import com.spidertech.libarySp.repositores.LoanRepository;
import com.spidertech.libarySp.repositores.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
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
		
		// Dados de livros
		Book b1 = new Book(null, "O Estrangeiro", LocalDate.of(2020, 5, 20), true);
		Book b2 = new Book(null, "1984", LocalDate.of(2018, 9, 15), true);
		Book b3 = new Book(null, "Dom Casmurro", LocalDate.of(2015, 2, 10), false);
		Book b4 = new Book(null, "A Revolução dos Bichos", LocalDate.of(2017, 11, 5), true);
		Book b5 = new Book(null, "O Pequeno Príncipe", LocalDate.of(2010, 3, 27), false);

		bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5));
	
		
		Loan l1 = new Loan(null, LoanStatus.ACTIVE, Instant.parse("2024-06-10T10:00:00Z"), u1, b1);
		Loan l2 = new Loan(null, LoanStatus.LATE, Instant.parse("2024-06-12T14:30:00Z"), u2, b2);
		Loan l3 = new Loan(null, LoanStatus.RETURNED, Instant.parse("2024-05-20T09:15:00Z"), u3, b3);
		Loan l4 = new Loan(null, LoanStatus.LATE, Instant.parse("2024-06-01T11:00:00Z"), u4, b5);
		Loan l6 = new Loan(null, LoanStatus.ACTIVE, Instant.parse("2024-06-15T08:00:00Z"), u1, b4);

		loanRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l6));
	}
	
	
	
}
