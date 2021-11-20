package com.loansapp.main.controllers;

import java.util.List;

import com.loansapp.main.models.PaymentMethod;
import com.loansapp.main.models.User;
import com.loansapp.main.models.UserPaymentMethod;
import com.loansapp.main.repository.IPaymentMethodRepository;
import com.loansapp.main.repository.IUserPaymentMethodRepository;
import com.loansapp.main.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userPaymentMethodController {
    
    @Autowired
    IUserPaymentMethodRepository userPaymentMethodRepo;

    @Autowired
    IPaymentMethodRepository paymentMethodRepo;

    @Autowired
    IUserRepository userRepo;

    @GetMapping(path = "/v1/api/user-payment-methods")
    public List<UserPaymentMethod> getAll() {
        return userPaymentMethodRepo.findAll();
    }
    
    @GetMapping(path = "/v1/api/user-payment-methods/{id}")
    public UserPaymentMethod getById(@PathVariable("id") Long id) {
        return userPaymentMethodRepo.getById(id);
    }

    @PutMapping(path = "/v1/api/user-payment-methods/{id}")
    public UserPaymentMethod update(@PathVariable("id") Long id, Long id_payment_method, String user_document) {
        UserPaymentMethod getUserPaymentMethod = userPaymentMethodRepo.getById(id);
        PaymentMethod getPaymentMethod = paymentMethodRepo.getById(id_payment_method);
        User getUser = userRepo.findByDocument(user_document);

        getUserPaymentMethod.setId_payment_method(getPaymentMethod);
        getUserPaymentMethod.setUsers_document(getUser);

        return userPaymentMethodRepo.save(getUserPaymentMethod);
    }

    @PostMapping(path = "/v1/api/user-payment-methods")
    public UserPaymentMethod create(Long id_payment_method, String user_document) {
        PaymentMethod getPaymentMethod = paymentMethodRepo.getById(id_payment_method);
        User getUser = userRepo.findByDocument(user_document);

        UserPaymentMethod newUserPaymentMethod = new UserPaymentMethod();
        newUserPaymentMethod.setId_payment_method(getPaymentMethod);
        newUserPaymentMethod.setUsers_document(getUser);

        return userPaymentMethodRepo.save(newUserPaymentMethod);
    }

    @DeleteMapping(path = "/v1/api/user-payment-methods/{id}")
    public String delete(@PathVariable("id") Long id) {
        userPaymentMethodRepo.deleteById(id);

        return "User payment method deleted";
    }
}
