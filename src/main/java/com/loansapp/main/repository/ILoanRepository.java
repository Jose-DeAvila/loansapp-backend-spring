package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.Loan;

public interface ILoanRepository extends JpaRepository<Loan, Long>{

}
