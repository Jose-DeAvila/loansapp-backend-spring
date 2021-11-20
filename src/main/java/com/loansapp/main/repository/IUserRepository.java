package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.User;

public interface IUserRepository extends JpaRepository<User, String> {
    User findByDocument(String document);
    
    void deleteByDocument(String document);
}
