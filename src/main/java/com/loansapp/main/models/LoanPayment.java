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
@Table(name = "loans_payments")
public class LoanPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_payment")
	private Payment id_payment;
	
	@ManyToOne
	@JoinColumn(name = "id_loan")
	private Loan id_loan;
	
	public LoanPayment(Payment _id_payment, Loan _id_loan) {
		this.id_loan = _id_loan;
		this.id_payment = _id_payment;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Payment getId_payment() {
		return id_payment;
	}

	public void setId_payment(Payment id_payment) {
		this.id_payment = id_payment;
	}

	public Loan getId_loan() {
		return id_loan;
	}

	public void setId_loan(Loan id_loan) {
		this.id_loan = id_loan;
	}
}
