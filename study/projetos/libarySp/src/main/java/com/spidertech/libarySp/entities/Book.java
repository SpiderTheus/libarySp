package com.spidertech.libarySp.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spidertech.libarySp.entities.builders.BookBuilder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_book")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;

	@ManyToMany
	@JoinTable(name = "tb_book_author", 
	joinColumns = @JoinColumn(name = "book_id"), 
	inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authores = new HashSet<>();

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'", timezone = "GMT")
	private transient LocalDate datePublisher;
	private boolean isAvalible; 

	@OneToOne(mappedBy = "book")
	@JsonIgnore
	private Loan loan;

	@ManyToMany
	@JoinTable(name = "tb_book_category", 
	joinColumns = @JoinColumn(name = "book_id"), 
	inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;

	public Book() {

	}

	public Book(BookBuilder builder) {
		super();
		this.title = builder.getTitle();
		this.authores = builder.getAuthores();
		this.datePublisher = builder.getDatePublisher();
		this.isAvalible = builder.isAvalible();
		this.categories = builder.getCategories();
		this.publisher = builder.getPublisher();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDatePublisher() {
		return datePublisher;
	}

	public void setDatePublisher(LocalDate datePublisher) {
		this.datePublisher = datePublisher;
	}

	public boolean isAvalible() {
		return isAvalible;
	}

	public void setAvalible(boolean isAvalible) {
		this.isAvalible = isAvalible;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public Set<Author> getAuthores() {
		return new HashSet<>(this.authores);
	}

	
	public void setAuthores(Set<Author> authores) {
		this.authores = new HashSet<>(authores);
	}

	public void setCategories(Set<Category> categories) {
		this.categories = new HashSet<>(categories);
	}

	public Set<Category> getCategories() {
		return new HashSet<>(this.categories);
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}

}
