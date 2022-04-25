package com.api.venda.vendams.clientHttp;

import java.util.Optional;

import com.api.venda.vendams.shared.ProdutoResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="cadastro-ms")
public interface ProdutoFeingClient {
    
    @GetMapping(path="/api/cadastro/pesquisar-por-codigo/{id}")
    Optional<ProdutoResponse> getProduto (@PathVariable String codigo);


    @PutMapping(path="/api/cadastro/modificar-estoque/{id}")
    public boolean putStock (@PathVariable String codigo, int novaQuantidade);
}
