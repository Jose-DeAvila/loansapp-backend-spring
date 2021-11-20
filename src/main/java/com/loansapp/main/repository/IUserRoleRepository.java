package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.UserRole;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long>{

}
