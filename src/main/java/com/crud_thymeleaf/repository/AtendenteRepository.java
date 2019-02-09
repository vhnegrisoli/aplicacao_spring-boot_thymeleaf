package com.crud_thymeleaf.repository;

import com.crud_thymeleaf.model.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
}
