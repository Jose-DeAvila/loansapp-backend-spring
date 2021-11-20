package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Long>{

}
