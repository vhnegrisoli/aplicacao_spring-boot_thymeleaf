package com.crud_thymeleaf.repository.ViewsRepository;

import com.crud_thymeleaf.model.ViewsModel.ProdutoQuantidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoQuantidadeRepository extends JpaRepository<ProdutoQuantidade, Integer> {
}
