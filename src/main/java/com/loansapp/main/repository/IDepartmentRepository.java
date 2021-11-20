package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Long>{

}
