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
import com.loansapp.main.repository.IBankRepository;

@RestController
public class bankController {
	@Autowired
	IBankRepository bankRepo;
	
	@GetMapping(path = "/v1/api/banks")
	public List<Bank> getAll() {
		return bankRepo.findAll();
	}
	
	@GetMapping(path = "/v1/api/banks/{cod_bank}")
	public Bank findByCod(@PathVariable("cod_bank") String cod_bank) {
		return bankRepo.getById(cod_bank);
	}
	
	@PutMapping(path = "/v1/api/banks")
	public Bank update(String bank_name, String cod_bank) {
		Bank bank = bankRepo.getById(cod_bank);
		bank.setBank_name(bank_name);
		
		return bankRepo.save(bank);
	}
	
	@PostMapping(path = "/v1/api/banks")
	public Bank create(String bank_name, String cod_bank) {
		Bank bank = new Bank();
		bank.setCod_bank(cod_bank);
		bank.setBank_name(bank_name);
		
		return bankRepo.save(bank);
	}
	
	@DeleteMapping(path = "/v1/api/banks/{cod_bank}")
	public String delete(@PathVariable("cod_bank") String cod_bank) {
		bankRepo.deleteById(cod_bank);
		
		return "Bank deleted";
	}
}
