package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.Assistant;

public interface IAssistancesRepository extends JpaRepository<Assistant, String> {
	Assistant findByDocument(String document);
    Assistant findByEmail(String email);
    
    void deleteByDocument(String document);
}
