package br.com.gestorvendas.usecases.venda;

import br.com.gestorvendas.dtos.ProdutoResponse;
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
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ListarVendas {

    private final VendaRepository vendaRepository;

    public List<VendaResponse> execute() {
        return vendaRepository.findAll().stream().map(v -> {
            var itens = v.getItens().stream().map(i ->
                    new VendaResponse.ItemVendaResponse(
                            new ProdutoResponse(
                                    i.getProduto().getId(),
                                    i.getProduto().getNome(),
                                    i.getProduto().getDescricao(),
                                    i.getProduto().getQuantidade(),
                                    i.getProduto().getPreco()
                            ),
                            i.getQuantidade()
                    )
            ).collect(Collectors.toList());

            double total = itens.stream()
                    .mapToDouble(i -> i.getProduto().getPreco() * i.getQuantidade())
                    .sum();

            return new VendaResponse(v.getId(), v.getDataHora(), itens, total);
        }).collect(Collectors.toList());
    }

}
