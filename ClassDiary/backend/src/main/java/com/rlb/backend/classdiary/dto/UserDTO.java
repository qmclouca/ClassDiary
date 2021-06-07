package com.rlb.backend.classdiary.dto;

import java.io.Serializable;

import com.rlb.backend.classdiary.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String role;

	public UserDTO () {
		
	}

	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.role = entity.getRole();
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
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	
	
}
