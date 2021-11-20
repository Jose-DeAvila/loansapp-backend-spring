package com.loansapp.main.controllers;

import java.util.List;

import com.loansapp.main.models.PaymentMethod;
import com.loansapp.main.repository.IPaymentMethodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class paymentMethodController {
    @Autowired
    IPaymentMethodRepository paymentMethodRepo;

    @GetMapping(path = "/v1/api/payment-method")
    public List<PaymentMethod> getAll() {
        return paymentMethodRepo.findAll();
    }

    @GetMapping(path = "/v1/api/payment-method/{id}")
    public PaymentMethod getById(Long id) {
        return paymentMethodRepo.getById(id);
    }

    @PutMapping(path = "/v1/api/payment-method/{id}")
    public PaymentMethod update(@PathVariable("id") Long id, String name) {
        PaymentMethod getPaymentMethod = paymentMethodRepo.getById(id);
        getPaymentMethod.setName(name);

        return paymentMethodRepo.save(getPaymentMethod);
    }

    @PostMapping(path = "/v1/api/payment-method")
    public PaymentMethod create(String name) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setName(name);

        return paymentMethodRepo.save(paymentMethod);
    }

    @DeleteMapping(path = "/v1/api/payment-method/{id}")
    public String delete(@PathVariable("id") Long id) {
        paymentMethodRepo.deleteById(id);
        return "Deleted";
    }
}
