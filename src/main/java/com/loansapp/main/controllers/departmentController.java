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
import com.loansapp.main.repository.IDepartmentRepository;

@RestController
public class departmentController {
	@Autowired
	IDepartmentRepository departmentRepo;
	
	@GetMapping(path = "/v1/api/departments")
	public List<Department> getAll(){
		return departmentRepo.findAll();
	}
	
	@GetMapping(path = "/v1/api/departments/{id}")
	public Department getById(@PathVariable("id") Long id) {
		return departmentRepo.getById(id);
	}
	
	@PutMapping(path = "/v1/api/departments")
	public Department update(Department _department) {
		Department departmentToChange = departmentRepo.getById(_department.getId());
		
		departmentToChange.setName(_department.getName());
		return departmentRepo.save(departmentToChange);
	}
	
	@PostMapping(path = "/v1/api/departments")
	public Department create(String department_name) {
		Department department = new Department(department_name);
		return departmentRepo.save(department);
	}
	
	@DeleteMapping(path = "/v1/api/departments/{id}") 
	public String delete(@PathVariable("id") Long id) {
		departmentRepo.deleteById(id);
		return "Department deleted";
	}
}
