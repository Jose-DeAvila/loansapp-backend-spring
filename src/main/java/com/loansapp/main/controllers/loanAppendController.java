package com.loansapp.main.controllers;

import java.util.List;

import com.loansapp.main.models.Loan;
import com.loansapp.main.models.LoanAppend;
import com.loansapp.main.models.LoanRequest;
import com.loansapp.main.repository.ILoanAppendRepository;
import com.loansapp.main.repository.ILoanRepository;

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
    
    @Autowired
    ILoanRepository loanRepo;

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
    public Loan create(LoanAppend loanAppend) {
    	Loan loanToSave = new Loan();
    	loanToSave.setDebtor_document(loanAppend.getDebtor_document());
    	loanToSave.setFees(loanAppend.getFees());
    	loanToSave.setLender_code(loanAppend.getLender_code().toString());
    	loanToSave.setPayment_amount(loanAppend.getAmount());
    	loanToSave.setReason(loanAppend.getReason());
    	loanToSave.setTotal_ayment_amount(loanAppend.getAmount() * loanAppend.getFees());
    	
    	loanAppendRepo.save(loanAppend);
    	return loanRepo.save(loanToSave);
    }

    @DeleteMapping(path = "/v1/api/loan-appends/{id}")
    public String delete(@PathVariable("id") Long id) {
        loanAppendRepo.deleteById(id);
        return "Loan append deleted";
    }
}
