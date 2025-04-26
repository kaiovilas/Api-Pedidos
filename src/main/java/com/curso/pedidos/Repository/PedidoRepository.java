package com.curso.pedidos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.pedidos.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Long> {

}