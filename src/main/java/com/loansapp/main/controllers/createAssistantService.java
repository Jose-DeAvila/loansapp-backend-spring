package com.loansapp.main.controllers;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loansapp.main.models.Assistant;
import com.loansapp.main.repository.IAssistancesRepository;

@RestController
public class createAssistantService {
	private PasswordEncoder encoder;
	
	public createAssistantService() {
		this.encoder = new BCryptPasswordEncoder();
	}
	
	@Autowired
	IAssistancesRepository assistantRepo;
	
	@PostMapping(path = "/v1/api/admin/assistant")
	public HashMap<String, Object> createAssistant(Assistant assistant, HttpServletResponse response){
		ObjectMapper obj = new ObjectMapper();
		HashMap<String, Object> returnObj = new HashMap<>();
		try {
			response.setStatus(201);
			String encodedPassword = encoder.encode(assistant.getPassword());
			assistant.setPassword(encodedPassword);
			Assistant assistantSaved = assistantRepo.save(assistant);
			returnObj.put("message", "Assistent created successfully");
			returnObj.put("assistantInfo", obj.writeValueAsString(assistantSaved));
			
			return returnObj;
		} catch (Exception e) {
			returnObj.clear();
			returnObj.put("Error", "An error occurred creating assistant. Make sure all fields are full and document is not used by other.");
			
			return returnObj;
		}
	}
}
