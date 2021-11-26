package com.loansapp.main.controllers;

import java.util.List;

import com.loansapp.main.models.Loan;
import com.loansapp.main.models.LoanRequest;
import com.loansapp.main.repository.ILoanRepository;
import com.loansapp.main.repository.ILoanRequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loanRequestController {
    @Autowired
    ILoanRequestRepository loanRequestRepo;
    
    @Autowired
    ILoanRepository loanRepo;
    
    @GetMapping(path = "/v1/api/loan-request")
    public List<LoanRequest> getAll() {
        return loanRequestRepo.findAll();
    }

    @GetMapping(path = "/v1/api/loan-request/{id}")
    public LoanRequest getById(@PathVariable("id") Long id) {
        return loanRequestRepo.getById(id);
    }

    @PutMapping(path = "/v1/api/loan-request/{id}")
    public LoanRequest update(@PathVariable("id") Long id, LoanRequest loanRequest) {
        loanRequest.setId(id);
        return loanRequestRepo.save(loanRequest);
    }

    @PostMapping(path = "/v1/api/loan-request")
    public LoanRequest create(LoanRequest loanRequest) {
        return loanRequestRepo.save(loanRequest);
    }

    @DeleteMapping(path = "/v1/api/loan-request/{id}")
    public String delete(@PathVariable("id") Long id) {
        loanRequestRepo.deleteById(id);

        return "Loan request deleted";
    }
    
    @PostMapping(path = "/v1/api/loan-request/aprrove/{id}")
    public Loan approve(@PathVariable("id") Long id) {
    	LoanRequest loanGetted = loanRequestRepo.getById(id);
    	loanGetted.setStatus(true);
    	loanRequestRepo.save(loanGetted);
    	Loan loanToSave = new Loan();
    	loanToSave.setDebtor_document(loanGetted.getUser_document().getDocument());
    	loanToSave.setFees(loanGetted.getFees());
    	loanToSave.setLender_code(loanGetted.getLender_code());
    	loanToSave.setPayment_amount(loanGetted.getAmount());
    	loanToSave.setReason(loanGetted.getReason());
    	loanToSave.setTotal_ayment_amount(loanGetted.getAmount() * loanGetted.getFees());
    	
    	return loanRepo.save(loanToSave);
    }
}

