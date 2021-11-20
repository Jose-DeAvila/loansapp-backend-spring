package com.loansapp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loansapp.main.models.Role;
import com.loansapp.main.models.User;
import com.loansapp.main.models.UserRole;
import com.loansapp.main.repository.IRoleRepository;
import com.loansapp.main.repository.IUserRepository;
import com.loansapp.main.repository.IUserRoleRepository;

@RestController
public class userRolController {
	@Autowired
	IUserRoleRepository userRolRepo;
	
	@Autowired
	IRoleRepository roleRepo;
	
	@Autowired
	IUserRepository userRepo;
	
	@GetMapping(path = "/v1/api/user-roles")
	public List<UserRole> getAll() {
		return userRolRepo.findAll();
	}
	
	@GetMapping(path = "/v1/api/user-roles/{id}")
	public UserRole getById(@PathVariable("id") Long id) {
		return userRolRepo.getById(id);
	}
	
	@PutMapping(path = "/v1/api/user-roles")
	public UserRole update(Long id, Long id_rol, String user_document) {
		UserRole getUserRole = userRolRepo.getById(id);
		Role getRol = roleRepo.getById(id_rol);
		User getUser = userRepo.getById(user_document);
		
		getUserRole.setId_rol(getRol);
		getUserRole.setUser_document(getUser);
		
		return userRolRepo.save(getUserRole);
	}
	
	@PostMapping(path = "/v1/api/user-roles")
	public UserRole create(Long id_rol, String user_document) {
		Role getRol = roleRepo.getById(id_rol);
		User getUser = userRepo.getById(user_document);
		
		UserRole userRole = new UserRole();
		userRole.setId_rol(getRol);
		userRole.setUser_document(getUser);
		
		return userRolRepo.save(userRole);
	}
	
	@DeleteMapping(path = "/v1/api/user-roles/{id}")
	public void delete(@PathVariable("id") Long id) {
		userRolRepo.deleteById(id);
		
		System.out.println("Deleted");
	}
}
