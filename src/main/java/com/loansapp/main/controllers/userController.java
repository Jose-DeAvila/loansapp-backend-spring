package com.loansapp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loansapp.main.models.Municipality;
import com.loansapp.main.models.User;
import com.loansapp.main.repository.IMunicipalityRepository;
import com.loansapp.main.repository.IUserRepository;

@RestController
public class userController {
	
	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	IMunicipalityRepository municipalityRepo;

    @GetMapping(path = "/v1/api/users")
    public List<User> getAll(){
    	return userRepo.findAll();
    }
    
    @GetMapping(path = "/v1/api/users/{document}")
    public User getByDocument(@PathVariable("document") String document) {
    	return userRepo.findByDocument(document);
    }
    
    @PutMapping(path = "/v1/api/users")
    public User udpate(String email, String firstname, String lastname, String lender_code, String password, String phone_number, Long id_city, String document) {
    	Municipality municipality = municipalityRepo.getById(id_city);
    	User userToChange = userRepo.findByDocument(document);
    	userToChange.setEmail(email);
    	userToChange.setFirstname(firstname);
    	userToChange.setLastname(lastname);
    	userToChange.setLender_code(lender_code);
    	userToChange.setPassword(password);
    	userToChange.setPhone_number(phone_number);
    	userToChange.setId_city(municipality);
    	
    	return userRepo.save(userToChange);
    }
    
    @PostMapping(path = "/v1/api/users")
    public User create(String email, String firstname, String lastname, String lender_code, String password, String phone_number, Long id_city, String document) {
    	Municipality municipality = municipalityRepo.getById(id_city);
    	
    	User user = new User();
    	user.setDocument(document);
   		user.setBalance(0);
    	user.setEmail(email);
    	user.setFirstname(firstname);
   		user.setLastname(lastname);
    	user.setLender_code(lender_code);
   		user.setPassword(password);
   		user.setPhone_number(phone_number);
    	user.setId_city(municipality);
    		
   		return userRepo.save(user); 	
    }
    
    @DeleteMapping(path = "/v1/api/users")
    public void delete(String document) {
    	userRepo.deleteByDocument(document);
    	System.out.println("Deleted");
    }
}
