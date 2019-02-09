package com.crud_thymeleaf.controller;

import com.crud_thymeleaf.model.Atendente;
import com.crud_thymeleaf.service.AtendenteServices;
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
@RequestMapping("/atendentes")
public class AtendenteController {

    @Autowired
    AtendenteServices atendenteServices;

    @GetMapping("/cadastrar")
    public String cadastrar(Atendente atendente) {
        return "Atendentes/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Atendente atendente) {
        atendenteServices.insereAtendente(atendente);
        return "redirect:/atendentes/listar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("atendentes", atendenteServices.buscaTodos());
        return "Atendentes/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, ModelMap model) {
        Optional<Atendente> retorno = atendenteServices.buscaUm(id);
        Atendente atendente = new Atendente();

        atendente.setId(retorno.get().getId());
        atendente.setNome(retorno.get().getNome());

        model.addAttribute("atendente", atendente);
        return "/Atendentes/cadastrar";
    }

    @PostMapping("/editar")
    public String edita(Atendente atendente) {
        atendenteServices.atualizaAtendente(atendente);
        return "redirect:/atendentes/listar";
    }

    @GetMapping("/remover/{id}")
    public String remove(@PathVariable("id") Long id) {
        Atendente atendente = new Atendente ();
        atendente.setId(id);
        atendenteServices.removeAtendente(atendente);
        return "redirect:/atendentes/listar";
    }

}
