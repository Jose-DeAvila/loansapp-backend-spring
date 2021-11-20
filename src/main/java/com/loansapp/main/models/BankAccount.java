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
@Table(name = "bank_accounts")
public class BankAccount {
	@Id
	@Column(name = "account_number", unique = true, columnDefinition = "VARCHAR(64)")
	private String account_number;
	
	@Column(name = "account_type", nullable = false)
	private String account_type;
	
	@ManyToOne
	@JoinColumn(name = "cod_bank", nullable = false)
	Bank cod_bank;
	
	public BankAccount(String _account_number, String _account_type, Bank _cod_bank) {
		this.account_number = _account_number;
		this.account_type = _account_type;
		this.cod_bank = _cod_bank;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public Bank getCod_bank() {
		return cod_bank;
	}

	public void setCod_bank(Bank cod_bank) {
		this.cod_bank = cod_bank;
	}
}
