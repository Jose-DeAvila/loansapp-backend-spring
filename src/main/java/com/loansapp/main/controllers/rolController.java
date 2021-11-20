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
import com.loansapp.main.repository.IRoleRepository;

@RestController
public class rolController {
	@Autowired
	IRoleRepository rolRepo;
	
	@GetMapping(path = "/v1/api/roles")
	public List<Role> getAll() {
		return rolRepo.findAll();
	}
	
	@GetMapping(path = "/v1/api/roles/{id}")
	public Role getById(@PathVariable("id") Long id) {
		return rolRepo.getById(id);
	}
	
	@PutMapping(path = "/v1/api/roles")
	public Role update(Long id, String rol_name) {
		Role rol = rolRepo.getById(id);
		rol.setRol_name(rol_name);
		
		return rolRepo.save(rol);
	}
	
	@PostMapping(path = "/v1/api/roles")
	public Role create(String rol_name) {
		Role rol = new Role();
		rol.setRol_name(rol_name);
		
		return rolRepo.save(rol);
	}
	
	@DeleteMapping(path = "/v1/api/roles/{id}")
	public void delete(@PathVariable("id") Long id) {
		rolRepo.deleteById(id);
		
		System.out.println("Deleted");
	}
}
