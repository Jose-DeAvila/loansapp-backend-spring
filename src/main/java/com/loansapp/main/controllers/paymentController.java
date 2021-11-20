package com.loansapp.main.controllers;

import java.util.Date;
import java.util.List;

import com.loansapp.main.models.Payment;
import com.loansapp.main.models.User;
import com.loansapp.main.repository.IPaymentRepository;
import com.loansapp.main.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class paymentController {
    @Autowired
    IPaymentRepository paymentRepo;

    @Autowired
    IUserRepository userRepo;

    @GetMapping(path = "/v1/api/payments")
    public List<Payment> getAll() {
        return paymentRepo.findAll();
    }

    @GetMapping(path = "/v1/api/payments/{id}")
    public Payment getById(@PathVariable("id") Long id) {
        return paymentRepo.getById(id);
    }

    @PutMapping(path = "/v1/api/payments")
    public Payment update(Long id, Date date, Long payment_amount, String debtor_document) {
        Payment getPayment = paymentRepo.getById(id);
        User getUser = userRepo.findByDocument(debtor_document);
        
        getPayment.setDate(date);
        getPayment.setPayment_amount(payment_amount);
        getPayment.setDebtor_document(getUser);

        return paymentRepo.save(getPayment);
    }

    @PostMapping(path = "/v1/api/payments")
    public Payment create(Date date, Long payment_amount, String debtor_document) {
        User getUser = userRepo.findByDocument(debtor_document); 
        Payment newPayment = new Payment();
        newPayment.setDate(date);
        newPayment.setPayment_amount(payment_amount);
        newPayment.setDebtor_document(getUser);

        return paymentRepo.save(newPayment);
    }

    @DeleteMapping(path = "/v1/api/payments/{id}")
    public String delete(@PathVariable("id") Long id) {
        paymentRepo.deleteById(id);

        return "Payment deleted";
    }
}
