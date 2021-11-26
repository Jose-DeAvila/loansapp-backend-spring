package com.loansapp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.loansapp.main.models.Assistant;
import com.loansapp.main.repository.IAssistancesRepository;

public class assistantController {
	PasswordEncoder encoder;
	
	public assistantController() {
		this.encoder = new BCryptPasswordEncoder();
	}
	
	@Autowired
	IAssistancesRepository assistantRepo;

    @GetMapping(path = "/v1/api/assistants")
    public List<Assistant> getAll(){
    	return assistantRepo.findAll();
    }
    
    @GetMapping(path = "/v1/api/assistants/{document}")
    public Assistant getByDocument(@PathVariable("document") String document) {
    	return assistantRepo.findByDocument(document);
    }
    
    @PutMapping(path = "/v1/api/assistants/{document}")
    public Assistant update(@PathVariable("document") String document, Assistant assistant) {
        assistant.setDocument(document);
        return assistantRepo.save(assistant);
    }
    
    @DeleteMapping(path = "/v1/api/assistants")
    public void delete(String document) {
    	assistantRepo.deleteByDocument(document);
    	System.out.println("Deleted");
    }
}
