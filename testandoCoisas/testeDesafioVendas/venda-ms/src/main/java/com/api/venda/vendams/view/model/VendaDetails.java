package com.api.venda.vendams.view.model;

import com.api.venda.vendams.shared.ProdutoResponse;

public class VendaDetails {
    
    private String codigo;
    private int quantidade;
    private String dataVenda;
    private ProdutoResponse produto;
    
    public ProdutoResponse getProduto() {
        return produto;
    }
    public void setProduto(ProdutoResponse produto) {
        this.produto = produto;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
}
