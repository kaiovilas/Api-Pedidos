package com.curso.pedidos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.pedidos.models.PedidoItem;

@Repository
public interface PedidoItemRepository extends JpaRepository <PedidoItem, Long> {

}
