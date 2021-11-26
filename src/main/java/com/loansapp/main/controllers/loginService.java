package com.loansapp.main.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loansapp.main.models.User;
import com.loansapp.main.repository.IUserRepository;

@RestController
public class loginService{

	PasswordEncoder decoder;
	
	public loginService() {
		this.decoder = new BCryptPasswordEncoder();
	}
	
	@Autowired
	IUserRepository userRepo;
	
	@PostMapping(value = "/v1/api/auth/login")
	public Map<String, Object> login(String email, String password, HttpServletResponse response) {
		User user = userRepo.findByEmail(email);
		ObjectMapper Obj = new ObjectMapper();
		System.out.println("Email: " + email);
		System.out.println("Password: " + password);
		if(user == null) {
			response.setStatus(401);
			Map<String, Object> badResponse = new HashMap<>();
			badResponse.put("Error", "Error!! Wrong credentials!");
			return badResponse;
		}else {
			Boolean logged = this.decoder.matches(password, user.getPassword());
			if(logged == true) {
				Map<String, Object> goodRequest = new HashMap<>();
				try {
					user.setPassword(null);
					goodRequest.put("userInfo", Obj.writeValueAsString(user));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				return goodRequest;
			}
			else {
				response.setStatus(401);
				Map<String, Object> badResponse = new HashMap<>();
				badResponse.put("Error", "Error!! Wrong credentials!");
				return badResponse;
			}
		}
	}
}
