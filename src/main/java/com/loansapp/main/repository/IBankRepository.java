package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.Bank;

public interface IBankRepository extends JpaRepository<Bank, String>{
	
}
