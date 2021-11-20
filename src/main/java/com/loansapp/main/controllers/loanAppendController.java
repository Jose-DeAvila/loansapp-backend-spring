package com.loansapp.main.controllers;

import java.util.List;

import com.loansapp.main.models.LoanAppend;
import com.loansapp.main.repository.ILoanAppendRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loanAppendController {
    @Autowired
    ILoanAppendRepository loanAppendRepo;

    @GetMapping(path = "/v1/api/loan-appends")
    public List<LoanAppend> getAll() {
        return loanAppendRepo.findAll();
    }

    @GetMapping(path = "/v1/api/loan-appends/{id}")
    public LoanAppend getById(@PathVariable("id") Long id) {
        return loanAppendRepo.getById(id);
    }

    @PutMapping(path = "/v1/api/loan-appends/{id}")
    public LoanAppend update(@PathVariable("id") Long id, LoanAppend loanAppend) {
        loanAppend.setId(id);
        return loanAppendRepo.save(loanAppend);
    }

    @PostMapping(path = "/v1/api/loan-appends")
    public LoanAppend create(LoanAppend loanAppend) {
        return loanAppendRepo.save(loanAppend);
    }

    @DeleteMapping(path = "/v1/api/loan-appends/{id}")
    public String delete(@PathVariable("id") Long id) {
        loanAppendRepo.deleteById(id);
        return "Loan append deleted";
    }
}
