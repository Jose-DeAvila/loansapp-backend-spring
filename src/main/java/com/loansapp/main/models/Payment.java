package com.loansapp.main.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name = "payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "payment_amount")
	private Long payment_amount;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "debtor_document")
	private User debtor_document;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(Long payment_amount) {
		this.payment_amount = payment_amount;
	}

	public User getDebtor_document() {
		return debtor_document;
	}

	public void setDebtor_document(User debtor_document) {
		this.debtor_document = debtor_document;
	}
}
