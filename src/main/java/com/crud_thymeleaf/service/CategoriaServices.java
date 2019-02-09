package com.crud_thymeleaf.service;

import com.crud_thymeleaf.model.Categoria;
import com.crud_thymeleaf.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServices {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> buscaTodos() {

        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscaUm(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria insereCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }


    public Categoria atualizaCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void removeCategoria(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }
}
