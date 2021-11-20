package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.LoanRequest;

public interface ILoanRequestRepository extends JpaRepository<LoanRequest, Long>{

}
