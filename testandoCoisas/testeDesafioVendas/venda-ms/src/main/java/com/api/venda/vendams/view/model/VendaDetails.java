package com.api.venda.vendams.view.model;

import com.api.venda.vendams.shared.ProdutoResponse;

public class VendaDetails {
    
    private String codigo;
    private int quantidadeVendida;
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
    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
    public String getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
}
