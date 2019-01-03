package com.crud_thymeleaf.repositories;

import com.crud_thymeleaf.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository <Pedido, Long> {

}
