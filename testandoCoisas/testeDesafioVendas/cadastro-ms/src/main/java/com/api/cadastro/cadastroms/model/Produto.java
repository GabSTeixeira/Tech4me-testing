package com.api.cadastro.cadastroms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("produto")
public class Produto {
    @Id
    private String id;
    private String nome;
    private String codigo;
    private double preco;
    private int quantidade;
    
    public boolean removerEstoque (int quantidadeRemover) {
        if ((this.quantidade - quantidadeRemover) < 0) {
            return false;
        }
    
        this.quantidade -= quantidadeRemover;

        return true;

    }
    
    public int getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
