package com.crud_thymeleaf.services;

import com.crud_thymeleaf.domain.Produto;
import com.crud_thymeleaf.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServices {
    
    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> buscaTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscaUm(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto insereProduto(Produto produto) {
        return produtoRepository.save(produto);
    }


    public Produto atualizaProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void removeProduto(Produto produto) {
        produtoRepository.delete(produto);
    }

}
