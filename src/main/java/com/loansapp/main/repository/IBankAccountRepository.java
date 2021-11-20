package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.BankAccount;

public interface IBankAccountRepository extends JpaRepository<BankAccount, String>{
	
}
