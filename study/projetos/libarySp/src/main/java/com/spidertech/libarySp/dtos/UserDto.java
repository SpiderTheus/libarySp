package com.spidertech.libarySp.dtos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.spidertech.libarySp.entities.User;

public class UserDto {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private Set<LoanDto> loans = new HashSet<>();
	
	public UserDto() {
		
	}
	
	public UserDto(User user) {
		BeanUtils.copyProperties(user, this);
		this.loans = user.getLoans().stream().map(LoanDto::new).collect(Collectors.toSet());
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<LoanDto> getLoans() {
		return new HashSet<>(loans);
	}

	public void setLoans(Set<LoanDto> loans) {
		this.loans = new HashSet<>(loans);
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
		UserDto other = (UserDto) obj;
		return Objects.equals(id, other.id);
	}


}
