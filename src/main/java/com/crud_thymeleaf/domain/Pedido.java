package com.crud_thymeleaf.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Basic(optional = false)
    @Column(name = "quantidade")
    int quantidade;

    @Column(name = "data_pedido")
    String data_pedido;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Atendente atendente;

    public Pedido() {

    }

    public Pedido(Long id, int quantidade, String data_pedido, Produto produto, Cliente cliente, Atendente atendente) {
        this.id = id;
        this.quantidade = quantidade;
        this.data_pedido = data_pedido;
        this.produto = produto;
        this.cliente = cliente;
        this.atendente = atendente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return quantidade == pedido.quantidade &&
                Objects.equals(id, pedido.id) &&
                Objects.equals(data_pedido, pedido.data_pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantidade, data_pedido);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", data_pedido='" + data_pedido + '\'' +
                '}';
    }
}

