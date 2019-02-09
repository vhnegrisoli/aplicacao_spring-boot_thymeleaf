package com.crud_thymeleaf.service;

import com.crud_thymeleaf.model.Pedido;
import com.crud_thymeleaf.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServices {
    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedido> buscaTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscaUm(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido inserePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }


    public Pedido atualizaPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void removePedido(Pedido pedido) {
        pedidoRepository.delete(pedido);
    }

}
