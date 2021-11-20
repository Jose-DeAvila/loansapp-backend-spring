package com.loansapp.main.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name = "user_roles")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Role id_rol;
	
	@ManyToOne
	@JoinColumn(name = "user_document")
	private User user_document;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getId_rol() {
		return id_rol;
	}

	public void setId_rol(Role id_rol) {
		this.id_rol = id_rol;
	}

	public User getUser_document() {
		return user_document;
	}

	public void setUser_document(User user_document) {
		this.user_document = user_document;
	}
}
