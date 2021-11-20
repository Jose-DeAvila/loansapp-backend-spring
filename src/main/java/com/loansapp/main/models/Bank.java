package com.loansapp.main.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name = "banks")
public class Bank {
	@Id
	@Column(name = "cod_bank", unique = false, columnDefinition = "VARCHAR(64)")
	private String cod_bank;
	
	@Column(name = "bank_name", unique = true, nullable = false, columnDefinition = "VARCHAR(64)")
	private String bank_name;

	public Bank() {
		
	}
	
	public String getCod_bank() {
		return cod_bank;
	}

	public void setCod_bank(String cod_bank) {
		this.cod_bank = cod_bank;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
}
