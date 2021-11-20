package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.loansapp.main.models.UserBankAccount;

public interface IUserBankAccountRepository extends JpaRepository<UserBankAccount, Long>{

}
