package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.LoanPayment;

public interface ILoanPaymentRepository extends JpaRepository<LoanPayment, Long>{

}
