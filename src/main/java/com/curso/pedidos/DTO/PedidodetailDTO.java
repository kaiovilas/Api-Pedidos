package com.curso.pedidos.DTO;

import java.util.List;

import com.curso.pedidos.models.Item;
import com.curso.pedidos.models.Pedido;

public class PedidodetailDTO {

    private Pedido pedido;
    private List<Item> itens;

    public PedidodetailDTO() {
    }

    public PedidodetailDTO(Pedido pedido, List<Item> itens) {
        this.pedido = pedido;
        this.itens = itens;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

}
