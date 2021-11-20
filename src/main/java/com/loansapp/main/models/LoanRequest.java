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
@Table(name = "loans_requests")
public class LoanRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_document")
	private User user_document;
	
	@Column(name = "lender_code")
	private String lender_code;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "fees")
	private Double fees;
	
	public LoanRequest(User _user_document, String _lender_code, String _reason, Double _amount, Boolean _status, Double _fees) {
		this.user_document = _user_document;
		this.lender_code = _lender_code;
		this.reason = _reason;
		this.amount = _amount;
		this.status = _status;
		this.fees = _fees;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser_document() {
		return user_document;
	}

	public void setUser_document(User user_document) {
		this.user_document = user_document;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}
}
