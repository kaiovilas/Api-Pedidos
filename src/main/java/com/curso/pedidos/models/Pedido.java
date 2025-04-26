package com.curso.pedidos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pedido {
    @Id
    @GeneratedValue
    private Long id;
    private String cpf;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pedido(Long id, String cpf) {
        this.id = id;
        this.cpf = cpf;
    }

    public Pedido(){

    }
}
