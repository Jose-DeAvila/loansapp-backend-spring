package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.UserPaymentMethod;

public interface IUserPaymentMethodRepository extends JpaRepository<UserPaymentMethod, Long>{

}
