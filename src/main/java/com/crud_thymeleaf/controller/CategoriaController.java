package com.crud_thymeleaf.controller;

import com.crud_thymeleaf.model.Categoria;
import com.crud_thymeleaf.service.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaServices categoriaServices;

    @GetMapping("/cadastrar")
    public String cadastrar(Categoria categoria) {
        return "Categorias/cadastrar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("categorias", categoriaServices.buscaTodos());
        return "Categorias/listar"
;    }

    @PostMapping("/salvar")
    public String salvar(@Valid Categoria categoria) {
        categoriaServices.insereCategoria(categoria);
        return "redirect:/categorias/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, ModelMap model) {
        Optional<Categoria> retorno = categoriaServices.buscaUm(id);
        Categoria categoria = new Categoria();
        categoria.setId(retorno.get().getId());
        categoria.setDescricao(retorno.get().getDescricao());
        model.addAttribute("categoria", categoria);
        return "/Categorias/cadastrar";
    }

    @PostMapping("/editar")
    public String edita(Categoria categoria) {
        categoriaServices.insereCategoria(categoria);
        return "redirect:/categorias/listar";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable("id") Long id) {
        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoriaServices.removeCategoria(categoria);
        return "redirect:/categorias/listar";
    }

}