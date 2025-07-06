package com.spidertech.libarySp.dtos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class BookBuilderDto {

	private String title;
	private Set<Long> idAuthors = new HashSet<>();
	private LocalDate datePublisher;
	private boolean isAvalible;
	private String nameCategory;
	private Long idPublisher;

	public BookBuilderDto() {
		// TODO Auto-generated constructor stub
	}

	public BookBuilderDto(String title, Set<Long> idAuthors, LocalDate datePublisher, boolean isAvalible,
			String nameCategory, Long idPublisher) {
		super();
		this.title = title;
		this.idAuthors = idAuthors;
		this.datePublisher = datePublisher;
		this.isAvalible = isAvalible;
		this.nameCategory = nameCategory;
		this.idPublisher = idPublisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Long> getIdAuthors() {
		return idAuthors;
	}

	public void setIdAuthors(Set<Long> idAuthors) {
		this.idAuthors = idAuthors;
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

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public Long getIdPublisher() {
		return idPublisher;
	}

	public void setIdPublisher(Long idPublisher) {
		this.idPublisher = idPublisher;
	}
	
	

}
