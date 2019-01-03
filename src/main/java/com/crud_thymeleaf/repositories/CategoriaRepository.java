package com.crud_thymeleaf.repositories;

import com.crud_thymeleaf.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
