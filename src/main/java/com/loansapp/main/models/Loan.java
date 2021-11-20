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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "debtor_document", nullable = false)
	private LoanAppend debtor_document;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lender_code", nullable = false)
	private LoanAppend lender_code;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reason", nullable = false)
	private LoanAppend reason;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_amount", nullable = false)
	private LoanAppend payment_amount;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fees", nullable = false)
	private LoanAppend fees;
	
	@Column(name = "total_payment_amount", nullable = false)
	private Double total_payment_amount;
	
	public Loan(LoanAppend _debtor_document, LoanAppend _lender_code, LoanAppend _reason, LoanAppend _payment_amount, LoanAppend _fees) {
		this.debtor_document = _debtor_document;
		this.lender_code = _lender_code;
		this.reason = _reason;
		this.payment_amount = _payment_amount;
		this.fees = _fees;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LoanAppend getDebtor_document() {
		return debtor_document;
	}

	public void setDebtor_document(LoanAppend debtor_document) {
		this.debtor_document = debtor_document;
	}

	public LoanAppend getLender_code() {
		return lender_code;
	}

	public void setLender_code(LoanAppend lender_code) {
		this.lender_code = lender_code;
	}

	public LoanAppend getReason() {
		return reason;
	}

	public void setReason(LoanAppend reason) {
		this.reason = reason;
	}

	public LoanAppend getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(LoanAppend payment_amount) {
		this.payment_amount = payment_amount;
	}

	public LoanAppend getFees() {
		return fees;
	}

	public void setFees(LoanAppend fees) {
		this.fees = fees;
	}

	public Double getTotal_ayment_amount() {
		return total_payment_amount;
	}

	public void setTotal_ayment_amount(Double total_ayment_amount) {
		this.total_payment_amount = total_ayment_amount;
	}
}
