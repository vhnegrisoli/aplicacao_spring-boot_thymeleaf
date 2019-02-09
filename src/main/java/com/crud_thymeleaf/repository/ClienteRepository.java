package com.crud_thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud_thymeleaf.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
