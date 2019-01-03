package com.crud_thymeleaf.repositories;

import com.crud_thymeleaf.domain.Categoria;
import com.crud_thymeleaf.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
