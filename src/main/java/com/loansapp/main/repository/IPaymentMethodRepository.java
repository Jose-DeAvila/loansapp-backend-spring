package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.PaymentMethod;

public interface IPaymentMethodRepository extends JpaRepository<PaymentMethod, Long>{

}
