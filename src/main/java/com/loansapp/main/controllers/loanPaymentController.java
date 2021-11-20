package com.loansapp.main.controllers;

import java.util.List;

import com.loansapp.main.models.LoanPayment;
import com.loansapp.main.repository.ILoanPaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loanPaymentController {
    @Autowired
    ILoanPaymentRepository loanPaymentRepo;

    @GetMapping(path = "/v1/api/loan-payments")
    public List<LoanPayment> getAll() {
        return loanPaymentRepo.findAll();
    }

    @GetMapping(path = "/v1/api/loan-payments/{id}")
    public LoanPayment getById(@PathVariable("id") Long id) {
        return loanPaymentRepo.getById(id);
    }

    @PutMapping(path = "/v1/api/loan-payments/{id}")
    public LoanPayment update(@PathVariable("id") Long id, LoanPayment loanPayment) {
        loanPayment.setId(id);
        return loanPaymentRepo.save(loanPayment);
    }

    @PostMapping(path = "/v1/api/loan-payments")
    public LoanPayment create(LoanPayment loanPayment) {
        return loanPaymentRepo.save(loanPayment);
    }

    @DeleteMapping(path = "/v1/api/loan-payments/{id}")
    public String delete(@PathVariable("id") Long id) {
        loanPaymentRepo.deleteById(id);
        return "Loan payment deleted";
    }
}
