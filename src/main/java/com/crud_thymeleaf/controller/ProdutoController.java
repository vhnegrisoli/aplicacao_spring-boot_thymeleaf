package com.crud_thymeleaf.controller;

import com.crud_thymeleaf.model.Categoria;
import com.crud_thymeleaf.model.Produto;
import com.crud_thymeleaf.service.CategoriaServices;
import com.crud_thymeleaf.service.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoServices produtoServices;

    @Autowired
    CategoriaServices categoriaServices;

    @GetMapping("/cadastrar")
    public String cadastrar(Produto produto) {
        return "Produtos/cadastrar";
    }

    @ModelAttribute("categorias")
    public List<Categoria> listaDeCategorias() {
        return categoriaServices.buscaTodos();
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Produto produto) {
        produtoServices.insereProduto(produto);
        return "redirect:/produtos/listar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("produtos", produtoServices.buscaTodos());
        return "Produtos/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, ModelMap model) {
        Optional<Produto> retorno = produtoServices.buscaUm(id);
        Produto produto = new Produto();
        produto.setId(retorno.get().getId());
        produto.setDescricao(retorno.get().getDescricao());
        model.addAttribute("produto", produto);
        return "/Produtos/cadastrar";
    }

    @PostMapping("/editar")
    public String edita(Produto produto) {
        produtoServices.insereProduto(produto);
        return "redirect:/produtos/listar";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable("id") Long id) {
        Produto produto = new Produto();
        produto.setId(id);
        produtoServices.removeProduto(produto);
        return "redirect:/produtos/listar";
    }

}
