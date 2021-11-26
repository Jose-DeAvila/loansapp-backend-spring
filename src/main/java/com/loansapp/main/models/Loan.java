package com.loansapp.main.models;

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
@Table(name = "loans")
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "debtor_document", nullable = false)
	private String debtor_document;
	
	@Column(name = "lender_code", nullable = false)
	private String lender_code;
	
	@Column(name = "reason", nullable = false)
	private String reason;
	
	@Column(name = "payment_amount", nullable = false)
	private Double payment_amount;
	
	@Column(name = "fees", nullable = false)
	private Double fees;
	
	@Column(name = "total_payment_amount", nullable = false)
	private Double total_payment_amount;
	
	public Loan(String _debtor_document, String _lender_code, String _reason, Double _payment_amount, Double _fees) {
		this.debtor_document = _debtor_document;
		this.lender_code = _lender_code;
		this.reason = _reason;
		this.payment_amount = _payment_amount;
		this.fees = _fees;
		
		this.total_payment_amount = _payment_amount * _fees;
	}
	
	public Loan() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDebtor_document() {
		return debtor_document;
	}

	public void setDebtor_document(String debtor_document) {
		this.debtor_document = debtor_document;
	}

	public String getLender_code() {
		return lender_code;
	}

	public void setLender_code(String lender_code) {
		this.lender_code = lender_code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Double getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(Double payment_amount) {
		this.payment_amount = payment_amount;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public Double getTotal_ayment_amount() {
		return total_payment_amount;
	}

	public void setTotal_ayment_amount(Double total_ayment_amount) {
		this.total_payment_amount = total_ayment_amount;
	}
}
