package com.loansapp.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.Loan;

public interface ILoanRepository extends JpaRepository<Loan, Long>{
	List<Loan> findByDebtor_document(String debtor_document);
}
