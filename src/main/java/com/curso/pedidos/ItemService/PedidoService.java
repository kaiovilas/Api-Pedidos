package com.curso.pedidos.ItemService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.pedidos.Repository.PedidoRepository;
import com.curso.pedidos.models.Pedido;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Optional<Pedido> buscarPedidoId(Long id) {
        return pedidoRepository.findById(id);
    }

    public void deactivePedido(Long id) {
        Optional<Pedido> pedidoExistente = pedidoRepository.findById(id);
        if (pedidoExistente.isPresent()) {
            pedidoExistente.get().setAtivado(false);
            pedidoRepository.save(pedidoExistente.get());
        }
    }
}
