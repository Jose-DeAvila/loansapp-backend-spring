package com.loansapp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loansapp.main.models.Department;
import com.loansapp.main.models.Municipality;
import com.loansapp.main.repository.IDepartmentRepository;
import com.loansapp.main.repository.IMunicipalityRepository;

@RestController
public class municipalityController {
	@Autowired
	IMunicipalityRepository municipalityRepo;
	
	@Autowired
	IDepartmentRepository departmentRepo;
	
	@GetMapping(path = "/v1/api/municipalities")
	public List<Municipality> getAll(){
		return municipalityRepo.findAll();
	}
	
	@GetMapping(path = "/v1/api/municipalities/{id}")
	public Municipality getById(@PathVariable("id") Long id) {
		return municipalityRepo.getById(id);
	}
	
	@PutMapping(path = "/v1/api/municipalities")
	public Municipality update(Long id, String nombre, Long id_department) {
		Municipality municipalityToChange = municipalityRepo.getById(id);
		Department getDepartment = departmentRepo.getById(id_department);
		
		municipalityToChange.setName(nombre);
		municipalityToChange.setId_department(getDepartment);
		
		return municipalityRepo.save(municipalityToChange);
	}
	
	@PostMapping(path = "/v1/api/municipalities")
	public Municipality create(String name, Long id_department) {
		Municipality municipality = new Municipality();
		Department department = departmentRepo.getById(id_department);
		
		municipality.setName(name);
		municipality.setId_department(department);
		
		return municipalityRepo.save(municipality);
	}
	
	@DeleteMapping(path = "v1/api/municipalities/{id}")
	public void delete(@PathVariable("id") Long id) {
		municipalityRepo.deleteById(id);
		System.out.println("Deleted");
	}
}
