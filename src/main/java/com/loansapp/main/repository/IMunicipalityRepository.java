package com.loansapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loansapp.main.models.Municipality;

public interface IMunicipalityRepository extends JpaRepository<Municipality, Long>{

}
