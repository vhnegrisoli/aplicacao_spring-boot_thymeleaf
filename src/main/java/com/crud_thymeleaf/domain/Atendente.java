package com.crud_thymeleaf.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "atendente")
public class Atendente {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic (optional = false)
    Long id;

    @Column(name = "nome")
    @Basic(optional = false)
    String nome;

    public Atendente() {
    }

    public Atendente(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atendente atendente = (Atendente) o;
        return Objects.equals(id, atendente.id) &&
                Objects.equals(nome, atendente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
