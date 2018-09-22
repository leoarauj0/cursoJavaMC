package com.star.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Produto implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name = "id_produto")
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "nome_produto")
    private String nome;

    @Column(name = "preco_produto")
    private Double preço;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "produto_categoria",
        joinColumns = @JoinColumn(name = "id_produto"),
        inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private List<Categoria> categorias = new ArrayList<>();

    public Produto() {
    }

    public Produto(Integer id, String nome, Double preço) {
        super();
        this.id = id;
        this.nome = nome;
        this.preço = preço;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreço() {
        return preço;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
