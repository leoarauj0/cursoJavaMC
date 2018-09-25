package com.star.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ItemPedido implements Serializable {
    public static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId //id imbultido em uma classe auxiliar
    private ItemPedidoPK id = new ItemPedidoPK();
    public ItemPedido() {
    }
    private Double desconto;
    private Integer quantidade;
    private Double preco;



    public ItemPedido(Pedido pedido, Produto produto,Double desconto, Integer quantidade, Double preco) {

        super();
        id.setPedido(pedido);
        id.setProduto(produto);

        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    @JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }

    public Produto getProduto() {
        return id.getProduto();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
