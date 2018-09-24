package com.star.cursomc.domain;

import com.star.cursomc.domain.enums.EstadoPagamento;

import java.util.Date;

public class PagamentoComCartao extends Pagamento {
    public static final long serialVersionUID = 1L;

    private Integer quantParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Integer quantParcelas) {
        super(id, estadoPagamento, pedido);
        this.quantParcelas = quantParcelas;
    }

    public Integer getQuantParcelas() {
        return quantParcelas;
    }

    public void setQuantParcelas(Integer quantParcelas) {
        this.quantParcelas = quantParcelas;
    }


}
