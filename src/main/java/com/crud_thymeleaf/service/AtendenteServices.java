package com.crud_thymeleaf.service;

import com.crud_thymeleaf.repository.AtendenteRepository;
import com.crud_thymeleaf.model.Atendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendenteServices {
    
    @Autowired
    AtendenteRepository atendenteRepository;


    public List<Atendente> buscaTodos() {

        return atendenteRepository.findAll();
    }

    public Optional<Atendente> buscaUm(Long id) {
        return atendenteRepository.findById(id);
    }

    public Atendente insereAtendente(Atendente atendente) {
        return atendenteRepository.save(atendente);
    }


    public Atendente atualizaAtendente(Atendente atendente) {
        return atendenteRepository.save(atendente);
    }

    public void removeAtendente(Atendente atendente) {
        atendenteRepository.delete(atendente);
    }
    
}
