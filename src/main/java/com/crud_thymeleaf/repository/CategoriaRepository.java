package com.crud_thymeleaf.repository;

import com.crud_thymeleaf.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
