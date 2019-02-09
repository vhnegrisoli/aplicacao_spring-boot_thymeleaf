package com.crud_thymeleaf.controller;

import com.crud_thymeleaf.model.ViewsModel.CategoriaQuantidade;
import com.crud_thymeleaf.model.ViewsModel.ClienteQuantidade;
import com.crud_thymeleaf.model.ViewsModel.MediaAtendente;
import com.crud_thymeleaf.model.ViewsModel.ProdutoQuantidade;
import com.crud_thymeleaf.repository.ViewsRepository.CategoriaQuantidadeRepository;
import com.crud_thymeleaf.repository.ViewsRepository.ClienteQuantidadeRepository;
import com.crud_thymeleaf.repository.ViewsRepository.MediaAtendenteRepository;
import com.crud_thymeleaf.repository.ViewsRepository.ProdutoQuantidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/relatorios")
public class ApiRestController {

    @Autowired
    private ClienteQuantidadeRepository clienteQuantidadeRepository;

    @Autowired
    private ProdutoQuantidadeRepository produtoQuantidadeRepository;

    @Autowired
    private MediaAtendenteRepository mediaAtendenteRepository;

    @Autowired
    private CategoriaQuantidadeRepository categoriaQuantidadeRepository;

    @GetMapping("/cliente-quantidade")
    public List<ClienteQuantidade> getClienteQuantidade() {
        return clienteQuantidadeRepository.findAll();
    }

    @GetMapping("/produto-quantidade")
    public List<ProdutoQuantidade> getProdutoQuantidade() {
        return produtoQuantidadeRepository.findAll();
    }

    @GetMapping("/media-atendente")
    public List<MediaAtendente> getMediaAtendente() {
        return mediaAtendenteRepository.findAll();
    }

    @GetMapping("/categoria-quantidade")
    public List<CategoriaQuantidade> getCategoriaQuantidade() {
        return categoriaQuantidadeRepository.findAll();
    }
}
