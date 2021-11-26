package com.loansapp.main.controllers;

import java.util.List;

import com.loansapp.main.models.Loan;
import com.loansapp.main.repository.ILoanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loanController {
    @Autowired
    ILoanRepository loanRepo;

    @GetMapping(path = "/v1/api/loans")
    public List<Loan> getAll() {
        return loanRepo.findAll();
    }
    
    @GetMapping(path = "/v1/api/loans/{debtor_document}")
    public List<Loan> getByDebtorDocument(@PathVariable("debtor_document") String debtor_document) {
    	return loanRepo.findByDebtor_document(debtor_document);
    }

    @GetMapping(path = "/v1/api/loans/{id}")
    public Loan getById(@PathVariable("id") Long id) {
        return loanRepo.getById(id);
    }

    @PutMapping(path = "/v1/api/loans/{id}")
    public Loan update(@PathVariable("id") Long id, Loan loan) {
        loan.setId(id);
        return loanRepo.save(loan);
    }

    @PostMapping(path = "/v1/api/loans")
    public Loan create(Loan loan) {
        return loanRepo.save(loan);
    }

    @DeleteMapping(path = "/v1/api/loans/{id}")
    public void delete(@PathVariable("id") Long id) {
        loanRepo.deleteById(id);
    }
}
