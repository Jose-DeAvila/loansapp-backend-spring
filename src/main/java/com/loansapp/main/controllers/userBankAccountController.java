package com.loansapp.main.controllers;

import java.util.List;

import com.loansapp.main.models.BankAccount;
import com.loansapp.main.models.User;
import com.loansapp.main.models.UserBankAccount;
import com.loansapp.main.repository.IBankAccountRepository;
import com.loansapp.main.repository.IUserBankAccountRepository;
import com.loansapp.main.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userBankAccountController {
    @Autowired
    IUserBankAccountRepository userBankAccountRepo;

    @Autowired
    IBankAccountRepository bankAccountRepo;

    @Autowired 
    IUserRepository userRepo;

    @GetMapping(path = "/v1/api/user-bank-accounts")
    public List<UserBankAccount> getAll() {
        return userBankAccountRepo.findAll();
    }

    @GetMapping(path = "/v1/api/user-bank-accounts/{id}")
    public UserBankAccount getById(Long id) {
        return userBankAccountRepo.getById(id);
    }

    @PutMapping(path = "/v1/api/user-bank-accounts/{id}")
    public UserBankAccount update(@PathVariable Long id, String account_number, String user_document) {
        UserBankAccount getUserBankAccount = userBankAccountRepo.getById(id);
        BankAccount getBankAccount = bankAccountRepo.getById(account_number);
        User getUser = userRepo.findByDocument(user_document);

        getUserBankAccount.setAccount_number(getBankAccount);
        getUserBankAccount.setUser_document(getUser);

        return userBankAccountRepo.save(getUserBankAccount);
    }

    @PostMapping(path = "/v1/api/user-bank-accounts")
    public UserBankAccount create(String account_number, String user_document) {
        BankAccount getBankAccount = bankAccountRepo.getById(account_number);
        User getUser = userRepo.findByDocument(user_document);

        UserBankAccount userBankAccount = new UserBankAccount();
        userBankAccount.setAccount_number(getBankAccount);
        userBankAccount.setUser_document(getUser);


        return userBankAccountRepo.save(userBankAccount);
    }

    @DeleteMapping(path = "/v1/api/user-bank-accounts/{id}")
    public String delete(@PathVariable Long id) {
        userBankAccountRepo.deleteById(id);
        return "User bank account deleted";
    }
}
