package com.curso.pedidos.models;

import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private Double valor;
    private Boolean ativado;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Item(Long id, String nome, Double valor, Boolean ativado) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.ativado = ativado;
    }

    public Item() {

    }

    public Boolean getAtivado() {
        return ativado;
    }

    public void setAtivado(Boolean ativado) {
        this.ativado = ativado;
    }

}
