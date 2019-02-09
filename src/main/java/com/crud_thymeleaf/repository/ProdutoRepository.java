package com.crud_thymeleaf.repository;

import com.crud_thymeleaf.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
