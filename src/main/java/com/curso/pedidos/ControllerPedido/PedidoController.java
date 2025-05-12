package com.curso.pedidos.ControllerPedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.pedidos.DTO.PedidoDTO;
import com.curso.pedidos.DTO.PedidodetailDTO;
import com.curso.pedidos.ItemService.PedidoService;
import com.curso.pedidos.models.Pedido;

@RestController
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/pedidos")
    public List<Pedido> listarTodos() {
        return pedidoService.listar();
    }

    @GetMapping("/pedidos/{id}")
    public PedidodetailDTO listarId(@PathVariable Long id) {
        return pedidoService.buscarPedidoId(id);
    }

    @PostMapping("/pedidos")
    public void criarPedido(@RequestBody PedidoDTO pedido) {
        pedidoService.criarPedido(pedido);
    }

    @DeleteMapping("/pedidos/{id}")
    public void desativarPedido(@PathVariable Long id) {
        pedidoService.deactivePedido(id);
    }
}
