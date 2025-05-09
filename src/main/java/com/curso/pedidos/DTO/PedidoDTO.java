package com.curso.pedidos.DTO;

import java.util.List;

import com.curso.pedidos.models.Pedido;

public class PedidoDTO {

    private String cpf;
    private List<Long> itens;

    public PedidoDTO() {

    }

    public PedidoDTO(String cpf, List<Long> itens) {
        this.cpf = cpf;
        this.itens = itens;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Long> getItens() {
        return itens;
    }

    public void setItens(List<Long> itens) {
        this.itens = itens;
    }

    public Pedido toEntity(){
        Pedido pedido = new Pedido();
        pedido.setCpf(cpf);
        return pedido;

    }

}
