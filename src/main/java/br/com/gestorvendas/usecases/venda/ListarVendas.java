package br.com.gestorvendas.usecases.venda;

import br.com.gestorvendas.dtos.VendaRequest;
import br.com.gestorvendas.dtos.VendaResponse;
import br.com.gestorvendas.exceptions.ProdutoNaoEncontrado;
import br.com.gestorvendas.model.ItemVendaEntity;
import br.com.gestorvendas.model.ProdutoEntity;
import br.com.gestorvendas.model.VendaEntity;
import br.com.gestorvendas.repository.ProdutoRepository;
import br.com.gestorvendas.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarVendas {

    private final VendaRepository vendaRepository;


    public List<VendaResponse> execute() {
        return vendaRepository.findAll().stream().map(VendaResponse::of).toList();
    }
}
