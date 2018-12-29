package com.crud_thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud_thymeleaf.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
