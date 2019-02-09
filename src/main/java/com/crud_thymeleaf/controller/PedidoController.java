package com.crud_thymeleaf.controller;

import com.crud_thymeleaf.model.*;
import com.crud_thymeleaf.service.AtendenteServices;
import com.crud_thymeleaf.service.ClienteServices;
import com.crud_thymeleaf.service.PedidoServices;
import com.crud_thymeleaf.service.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoServices pedidoServices;

    @Autowired
    ClienteServices clienteServices;

    @Autowired
    AtendenteServices atendenteServices;

    @Autowired
    ProdutoServices produtoServices;

    @ModelAttribute("clientes")
    public List<Cliente> listaDeClientes() {
        return clienteServices.buscaTodos();
    }

    @ModelAttribute("produtos")
    public List<Produto> listaDeProdutos() {
        return produtoServices.buscaTodos();
    }

    @ModelAttribute("atendentes")
    public List<Atendente> listaDeAtendentes() {
        return atendenteServices.buscaTodos();
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Pedido pedido) {
        return "Pedidos/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Pedido pedido) {
        pedidoServices.inserePedido(pedido);
        return "redirect:/pedidos/listar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("pedidos", pedidoServices.buscaTodos());
        return "Pedidos/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, ModelMap model) {
        Optional<Pedido> retorno = pedidoServices.buscaUm(id);
        Pedido pedido = new Pedido();
        pedido.setId(retorno.get().getId());
        pedido.setQuantidade(retorno.get().getQuantidade());
        pedido.setData_pedido(retorno.get().getData_pedido());
        model.addAttribute("pedido", pedido);
        return "/Pedidos/cadastrar";
    }

    @PostMapping("/editar")
    public String edita(Pedido pedido) {
        pedidoServices.inserePedido(pedido);
        return "redirect:/pedidos/listar";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable("id") Long id) {
        Pedido pedido = new Pedido();
        pedido.setId(id);
        pedidoServices.removePedido(pedido);
        return "redirect:/pedidos/listar";
    }
}
