package com.api.venda.vendams.view.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VendaInsert {
    
    @NotBlank(message = "codigo não pode estar em branco")
    @NotEmpty(message = "codigo não pode ser vazio")
    private String codigo;
    @Min(1)
    @NotNull(message = "quantidade deve ter um valor")
    private int quantidade;
    private String dataVenda;
    
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
