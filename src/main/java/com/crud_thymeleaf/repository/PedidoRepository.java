package com.crud_thymeleaf.repository;

import com.crud_thymeleaf.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository <Pedido, Long> {

}
