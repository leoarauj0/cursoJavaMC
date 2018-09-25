package com.star.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.star.cursomc.domain.enums.TipoCliente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name = "cliente_id")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cliente_nome")
    private String nome;

    @Column(name = "cliente_email")
    private String email;

    @Column(name = "cliente_cpfOuCnpj")
    private String cpfOuCnpj;

    @Column(name = "cliente_tipo")
    private Integer tipo; //nao utilizamos o Tipo cliente para que fique salvo um int, no construtor fazemos a referencia desse int com o getCod

    @JsonManagedReference //indica que cliente pode serializar endereço para nao haver erros
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();


    //para nao ser criada uma classe so para telefones criamos uma coleção deles relacionadas a cliente
    //set é um conjunto que não aceita repetição
    @ElementCollection //para o jpa mapear a lista de telefones no banco como entidade fraca usamos a anotação @ElementCollection
    @CollectionTable(name="telefone")
    private Set<String> telefones = new HashSet<>();

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();


    public Cliente() {
    }

    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo.getCod(); //
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getTipo() {
        //return tipo;
        return TipoCliente.toEnum(tipo);

    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
