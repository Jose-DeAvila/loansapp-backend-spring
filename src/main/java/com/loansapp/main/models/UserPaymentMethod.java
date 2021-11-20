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
@Table(name = "user_payments_methods")
public class UserPaymentMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_payment_method")
	private PaymentMethod id_payment_method;
	
	@ManyToOne
	@JoinColumn(name = "user_document")
	private User users_document;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentMethod getId_payment_method() {
		return id_payment_method;
	}

	public void setId_payment_method(PaymentMethod id_payment_method) {
		this.id_payment_method = id_payment_method;
	}

	public User getUsers_document() {
		return users_document;
	}

	public void setUsers_document(User user_document) {
		this.users_document = user_document;
	}
	
	
}
