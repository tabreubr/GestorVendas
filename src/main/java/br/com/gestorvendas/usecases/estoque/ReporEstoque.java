package br.com.gestorvendas.usecases.estoque;

import br.com.gestorvendas.dtos.ProdutoRequest;
import br.com.gestorvendas.dtos.ReposicaoRequest;
import br.com.gestorvendas.model.ProdutoEntity;
import br.com.gestorvendas.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReporEstoque {

    private final ProdutoRepository produtoRepository;

    public void execute(ReposicaoRequest reposicao){
        ProdutoEntity produto = produtoRepository.findById(reposicao.getProduto())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com Id: " + reposicao.getProduto()));

        produto.reporEstoque(reposicao.getQuantidade());

        produtoRepository.save(produto);
    }
}
