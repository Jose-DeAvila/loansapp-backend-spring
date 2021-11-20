package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.LoanAppend;

public interface ILoanAppendRepository extends JpaRepository<LoanAppend, Long>{

}
