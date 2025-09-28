package br.com.gestorvendas.usecases.venda;

import br.com.gestorvendas.dtos.VendaRequest;
import br.com.gestorvendas.exceptions.ProdutoNaoEncontrado;
import br.com.gestorvendas.model.ItemVendaEntity;
import br.com.gestorvendas.model.ProdutoEntity;
import br.com.gestorvendas.model.VendaEntity;
import br.com.gestorvendas.repository.ItemVendaRepository;
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
public class RegistrarVenda {

    private final VendaRepository vendaRepository;
    //private final ItemVendaRepository itemVendaRepository;
    private final ProdutoRepository produtoRepository;


    @Transactional
    public void execute(VendaRequest request) {

        VendaEntity venda = new VendaEntity();
        venda.setDataHora(LocalDateTime.now());
        final var vendaCriada = vendaRepository.save(venda);

        List<ItemVendaEntity> itensVenda = new ArrayList<>();
        for (VendaRequest.ItemVenda item : request.getItens()) {
            ProdutoEntity produto = produtoRepository.findById(item.getProduto())
                    .orElseThrow(() -> new ProdutoNaoEncontrado(item.getProduto()));

            produto.decrementarEstoque(item.getQuantidade());
            produtoRepository.save(produto);

            ItemVendaEntity itemVenda = new ItemVendaEntity();
            itemVenda.setVenda(vendaCriada);
            itemVenda.setProduto(produto);
            itemVenda.setQuantidade(item.getQuantidade());
            itensVenda.add(itemVenda);
        }

        venda.setItens(itensVenda);
        vendaRepository.save(venda);
    }
}
