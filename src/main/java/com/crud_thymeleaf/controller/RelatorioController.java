package com.crud_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RelatorioController {

    @GetMapping
    public String relatorios() {
        return "Relatorios/relatorios";
    }

}
