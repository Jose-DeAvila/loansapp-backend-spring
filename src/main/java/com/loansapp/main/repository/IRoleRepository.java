package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.Role;

public interface IRoleRepository extends JpaRepository<Role, Long>{

}
