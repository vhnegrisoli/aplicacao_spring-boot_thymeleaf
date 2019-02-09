package com.crud_thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud_thymeleaf.model.Cliente;
import com.crud_thymeleaf.repository.ClienteRepository;

@Service
public class ClienteServices {
	
	@Autowired
	ClienteRepository clienteRepository;

	public List<Cliente> buscaTodos() {
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> buscaUm(Long id) {
		return clienteRepository.findById(id);
	}
	
	public Cliente insereCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente atualizaCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void removeCliente(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
}
