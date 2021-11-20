package com.loansapp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loansapp.main.models.Bank;
import com.loansapp.main.models.BankAccount;
import com.loansapp.main.repository.IBankAccountRepository;
import com.loansapp.main.repository.IBankRepository;

@RestController
public class bankAccountController {
	@Autowired
	IBankAccountRepository bankAccountRepo;
	
	@Autowired
	IBankRepository bankRepo;
	
	@GetMapping(path = "/v1/api/bank-accounts")
	public List<BankAccount> getAll() {
		return bankAccountRepo.findAll();
	}
	
	@GetMapping(path = "/v1/api/bank-accounts/{account_number}")
	public BankAccount getByAccountNumber(@PathVariable("account_number") String account_number) {
		return bankAccountRepo.getById(account_number);
	}
	
	@PutMapping(path = "/v1/api/bank-accounts")
	public BankAccount update(String account_number, String account_type, String cod_bank) {
		BankAccount bankAccount = bankAccountRepo.getById(account_number);
		Bank getBank = bankRepo.getById(cod_bank);
		bankAccount.setAccount_type(account_type);
		bankAccount.setCod_bank(getBank);
		
		return bankAccountRepo.save(bankAccount);
	}
	
	@PostMapping(path = "/v1/api/bank-accounts")
	public BankAccount create(String account_number, String account_type, String cod_bank) {
		Bank getBank = bankRepo.getById(cod_bank);
		BankAccount bankAccount = new BankAccount(account_number, account_type, getBank);
		
		return bankAccountRepo.save(bankAccount);
	}
	
	@DeleteMapping(path = "/v1/api/bank-accounts/{account_number}")
	public String delete(@PathVariable("account_number") String account_number) {
		bankRepo.deleteById(account_number);
		
		return "Bank account deleted";
	}
}
