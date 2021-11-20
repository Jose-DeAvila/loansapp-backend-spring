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
@Table(name = "users_banks_accounts")
public class UserBankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "account_number")
	private BankAccount account_number;
	
	@ManyToOne
	@JoinColumn(name = "user_document")
	private User user_document;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BankAccount getAccount_number() {
		return account_number;
	}

	public void setAccount_number(BankAccount account_number) {
		this.account_number = account_number;
	}

	public User getUser_document() {
		return user_document;
	}

	public void setUser_document(User user_document) {
		this.user_document = user_document;
	}
}
