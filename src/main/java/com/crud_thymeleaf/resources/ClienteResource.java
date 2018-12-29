package com.crud_thymeleaf.resources;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud_thymeleaf.domain.Cliente;
import com.crud_thymeleaf.services.ClienteServices;

@Controller
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	ClienteServices clienteServices;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cliente cliente) {
		return "Clientes/cadastrar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("clientes", clienteServices.buscaTodos());
		return "Clientes/listar";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cliente cliente) {
		clienteServices.insereCliente(cliente);
		return "redirect:/clientes/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, ModelMap model) {
		Optional <Cliente> retorno = clienteServices.buscaUm(id);
		Cliente cliente = new Cliente();
		
		cliente.setId(retorno.get().getId());
		cliente.setNome(retorno.get().getNome());
		cliente.setEndereco(retorno.get().getEndereco());
		cliente.setEmail(retorno.get().getEmail());
		
		model.addAttribute("cliente", cliente);
		return "/Clientes/cadastrar";
	}
	
	@PostMapping("/editar")
	public String edita(Cliente cliente) {
		clienteServices.atualizaCliente(cliente);
		return "redirect:/clientes/listar";
	}
	
	@GetMapping("/remover/{id}")
	public String remove(@PathVariable("id") Long id) {
		Cliente cliente = new Cliente ();
		cliente.setId(id);
		clienteServices.removeCliente(cliente);
		return "redirect:/clientes/listar";
	}
}
