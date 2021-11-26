package com.loansapp.main.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name = "assistants")
public class Assistant {
	@Id
	@Column(name = "document", unique = true, columnDefinition = "VARCHAR(255)")
	private String document;
	
	@Column(name = "firstname", columnDefinition = "VARCHAR(255)")
	private String firstname;
	
	@Column(name = "lastname", columnDefinition = "VARCHAR(255)")
	private String lastname;
	
	@Column(name = "email", unique = true, columnDefinition = "VARCHAR(255)")
	private String email;
	
	@Column(name = "password", columnDefinition = "VARCHAR(255)")
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "boss_document")
	private User boss_document;

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getBoss_document() {
		return boss_document;
	}

	public void setBoss_document(User boss_document) {
		this.boss_document = boss_document;
	}
}
