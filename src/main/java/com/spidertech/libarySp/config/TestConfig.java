package com.spidertech.libarySp.config;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.spidertech.libarySp.entities.Author;
import com.spidertech.libarySp.entities.Book;
import com.spidertech.libarySp.entities.Category;
import com.spidertech.libarySp.entities.Loan;
import com.spidertech.libarySp.entities.Publisher;
import com.spidertech.libarySp.entities.User;
import com.spidertech.libarySp.entities.builders.BookBuilder;
import com.spidertech.libarySp.entities.enums.LoanStatus;
import com.spidertech.libarySp.repositores.AuthorRepository;
import com.spidertech.libarySp.repositores.BookRepository;
import com.spidertech.libarySp.repositores.CategoryRepository;
import com.spidertech.libarySp.repositores.LoanRepository;
import com.spidertech.libarySp.repositores.PublisherRepository;
import com.spidertech.libarySp.repositores.UserRepository;
import com.spidertech.libarySp.services.AuthorService;
import com.spidertech.libarySp.services.CategoryService;
import com.spidertech.libarySp.services.PublisherService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PublisherRepository publisherRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PublisherService publisherService;

	@Override
	public void run(String... args) throws Exception {


		User u1 = new User("Matheus Moraes", "matheus@gmail.com", "77-98848-0213");
		User u2 = new User("Lucas Silva", "lucas.silva@gmail.com", "77-98847-1234");
		User u3 = new User("Ana Pereira", "ana.pereira@gmail.com", "77-98846-5678");
		User u4 = new User("Carlos Eduardo", "carlos.edu@gmail.com", "77-98845-8765");
		User u5 = new User("Fernanda Lima", "fernanda.lima@gmail.com", "77-98844-3456");

		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));

		Category c1 = new Category("Ficção");
		Category c2 = new Category("Romance");
		Category c3 = new Category("Terror");
		Category c4 = new Category("Suspense");
		Category c5 = new Category("Drama");
		Category c6 = new Category("Ciência");
		Category c7 = new Category("Biografia");
		Category c8 = new Category("Autoajuda");
		Category c9 = new Category("Tecnologia");
		Category c10 = new Category("História");

		categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));

		Publisher p1 = new Publisher(null, "Companhia das Letras", "São Paulo");
		Publisher p2 = new Publisher(null, "HarperCollins Brasil", "Rio de Janeiro");
		Publisher p3 = new Publisher(null, "Editora Record", "São Paulo");
		Publisher p4 = new Publisher(null, "Grupo Editorial Pensamento", "São Paulo");
		Publisher p5 = new Publisher(null, "Editora Intrínseca", "Rio de Janeiro");
		Publisher p6 = new Publisher(null, "Editora Aleph", "São Paulo");
		Publisher p7 = new Publisher(null, "DarkSide Books", "Rio de Janeiro");
		Publisher p8 = new Publisher(null, "Sextante", "Rio de Janeiro");
		Publisher p9 = new Publisher(null, "Zahar", "Rio de Janeiro");
		Publisher p10 = new Publisher(null, "Planeta", "São Paulo");

		publisherRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));

		Author a1 = new Author(null, "Albert Camus", "Drean, Argélia", LocalDate.of(1913, 11, 7));
		Author a2 = new Author(null, "George Orwell", "Motihari, Índia", LocalDate.of(1903, 6, 25));
		Author a3 = new Author(null, "Machado de Assis", "Rio de Janeiro, Brasil", LocalDate.of(1839, 6, 21));
		Author a4 = new Author(null, "Antoine de Saint-Exupéry", "Lyon, França", LocalDate.of(1900, 6, 29));

		authorRepository.saveAll(Arrays.asList(a1, a2, a3, a4));


		
		Book b1 = new BookBuilder(authorService, categoryService, publisherService)
				.title("O estrangeiro")
				.authores(Set.of(a1.getId()))
				.datePublisher(LocalDate.of(2020, 5, 20))
				.isAvalible(false)
				.categories(Set.of(c1.getName(), c5.getName()))
				.publisher(p3.getName())
				.build();

	
		Book b2 = new BookBuilder(authorService, categoryService, publisherService)
		        .title("1984")
		        .authores(Set.of(a2.getId()))
		        .datePublisher(LocalDate.of(2019, 4, 10))
		        .isAvalible(true)
		        .categories(Set.of(c1.getName(), c4.getName()))
		        .publisher(p2.getName())
		        .build();

		Book b3 = new BookBuilder(authorService, categoryService, publisherService)
		        .title("Dom Casmurro")
		        .authores(Set.of(a3.getId()))
		        .datePublisher(LocalDate.of(2018, 3, 15))
		        .isAvalible(true)
		        .categories(Set.of(c2.getName(), c5.getName()))
		        .publisher(p1.getName())
		        .build();

		Book b4 = new BookBuilder(authorService, categoryService, publisherService)
		        .title("O Pequeno Príncipe")
		        .authores(Set.of(a4.getId()))
		        .datePublisher(LocalDate.of(2021, 6, 1))
		        .isAvalible(true)
		        .categories(Set.of(c2.getName(), c8.getName()))
		        .publisher(p5.getName())
		        .build();

		Book b5 = new BookBuilder(authorService, categoryService, publisherService)
		        .title("A Revolução dos Bichos")
		        .authores(Set.of(a2.getId()))
		        .datePublisher(LocalDate.of(2022, 9, 5))
		        .isAvalible(true)
		        .categories(Set.of(c1.getName(), c10.getName()))
		        .publisher(p4.getName())
		        .build();

		bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5));

		Loan l1 = new Loan(LoanStatus.ACTIVE, Instant.parse("2024-06-10T10:00:00Z"), u1, b1);
		Loan l2 = new Loan(LoanStatus.LATE, Instant.parse("2024-06-12T14:30:00Z"), u2, b2);
		Loan l3 = new Loan(LoanStatus.RETURNED, Instant.parse("2024-05-20T09:15:00Z"), u3, b3);
		Loan l4 = new Loan(LoanStatus.LATE, Instant.parse("2024-06-01T11:00:00Z"), u4, b5);
		Loan l5 = new Loan(LoanStatus.ACTIVE, Instant.parse("2024-06-15T08:00:00Z"), u1, b4);

		loanRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
