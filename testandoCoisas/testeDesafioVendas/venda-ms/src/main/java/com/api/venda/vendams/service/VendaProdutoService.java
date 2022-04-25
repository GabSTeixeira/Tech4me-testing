package com.api.venda.vendams.service;

import java.util.List;
import java.util.Optional;

import com.api.venda.vendams.shared.VendaDto;
import com.api.venda.vendams.view.model.VendaDetails;

public interface VendaProdutoService {
    
    Optional<List<VendaDto>> listAll ();
    Optional<VendaDto> listUnique (String id);
    Optional<VendaDto> postUnique (VendaDto venda);
}
