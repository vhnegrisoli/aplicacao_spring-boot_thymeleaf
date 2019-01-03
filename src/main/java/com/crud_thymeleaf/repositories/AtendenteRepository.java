package com.crud_thymeleaf.repositories;

import com.crud_thymeleaf.domain.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
}
