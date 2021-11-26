package com.loansapp.main.controllers;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
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
	public HashMap<String, Object> create(String department_name, HttpServletResponse response) {
		HashMap<String, Object> returnObj = new HashMap<>();
		try {
			ObjectMapper obj = new ObjectMapper();
			if(department_name == null) {
				response.setStatus(400);
				returnObj.put("Error", "\"department_name\" parameter is required. Please verify it's send successfully");
				return returnObj;
			}else {			
				response.setStatus(201);
				Department department = new Department(department_name);
				returnObj.put("message", "Department created successfully");
				returnObj.put("departmentInfo", obj.writeValueAsString(departmentRepo.save(department)));
				return returnObj;
			}
		} catch (Exception e) {
			returnObj.clear();
			returnObj.put("Error", "An error has been occurred creating department. Maybe department already exists.");
			
			return returnObj;
		}
		
	}
	
	@DeleteMapping(path = "/v1/api/departments/{id}") 
	public String delete(@PathVariable("id") Long id) {
		departmentRepo.deleteById(id);
		return "Department deleted";
	}
}
