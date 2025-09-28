package br.com.gestorvendas.usecases.venda;

import br.com.gestorvendas.model.ItemVendaEntity;
import br.com.gestorvendas.model.ProdutoEntity;
import br.com.gestorvendas.model.VendaEntity;
import br.com.gestorvendas.repository.ProdutoRepository;
import br.com.gestorvendas.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CancelarVenda {

    private final VendaRepository vendaRepository;
    private final ProdutoRepository produtoRepository;

    @Transactional
    public void execute(Integer id){
        VendaEntity venda = vendaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Não foi possível cancelar, a venda " + id + "não existe"));

        for(ItemVendaEntity item : venda.getItens()) {
            ProdutoEntity produto = item.getProduto();
            produto.reporEstoque(item.getQuantidade());
            produtoRepository.save(produto);
        }

        vendaRepository.deleteById(id);
    }
}
