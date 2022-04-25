package com.api.venda.vendams.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.api.venda.vendams.clientHttp.ProdutoFeingClient;
import com.api.venda.vendams.model.Venda;
import com.api.venda.vendams.repository.VendaProdutoRepository;
import com.api.venda.vendams.shared.Produto;
import com.api.venda.vendams.shared.VendaDto;
import com.api.venda.vendams.view.model.VendaDetails;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VendaProdutoServiceImpl implements VendaProdutoService {

    private final ModelMapper  MAPPER = new ModelMapper();
    private final VendaProdutoRepository repository;
    private final ProdutoFeingClient cadastro;

    VendaProdutoServiceImpl (VendaProdutoRepository repository, ProdutoFeingClient cadastro) {
        this.repository = repository;
        this.cadastro = cadastro;
    }


    @Override
    public Optional<List<VendaDto>> listAll() {
         
        if (repository.count() < 1)  {
            return Optional.empty();
        }
        
        List<VendaDto> ListVendaDto = repository.findAll().stream()
        .map(dat -> MAPPER.map(dat, VendaDto.class)).collect(Collectors.toList());

        return Optional.of(ListVendaDto);
    }


    @Override
    public Optional<VendaDto> listUnique (String id) {

        Optional<Venda> repositoryResponse = repository.findById(id);
        
        if(repositoryResponse.isEmpty()) {
            return Optional.empty();
        }


        // fazer o metodo de buscar unico e dps fazer o metodo de vender
        VendaDto vendaDtoResponse = MAPPER.map(repositoryResponse.get(), VendaDto.class);

        return Optional.of(vendaDtoResponse);
    }


    @Override
    public Optional<VendaDto> postUnique (VendaDto venda) {
        boolean operationSucces = cadastro.putStock(venda.getCodigo(), venda.getQuantidade());
        
        if (!operationSucces) {
            return Optional.empty();
        }

        Venda vendaRequest = MAPPER.map(venda, Venda.class);
        Produto produtoRequest = MAPPER.map(cadastro.getProduto(vendaRequest.getCodigo()).get(), Produto.class);
        
        vendaRequest.setProduto(produtoRequest);
        
        if(vendaRequest.getDataVenda().isBlank() || vendaRequest.getDataVenda().isEmpty()) {    
            String actualDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
            
            vendaRequest.setDataVenda(actualDate);
        }
        
        Venda repositoryResponse = repository.save(vendaRequest);
        
        return Optional.of(MAPPER.map(repositoryResponse, VendaDto.class));
    }
    
    
}
