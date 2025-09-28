package br.com.gestorvendas.usecases.estoque;

import br.com.gestorvendas.dtos.ProdutoRequest;
import br.com.gestorvendas.exceptions.ProdutoNaoEncontrado;
import br.com.gestorvendas.model.ProdutoEntity;
import br.com.gestorvendas.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AtualizarProduto {

    private final ProdutoRepository produtoRepository;

    public void execute(Integer id, ProdutoRequest request){
        ProdutoEntity produtoEntity = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontrado(id));

        produtoEntity.setNome(request.getNome());
        produtoEntity.setDescricao(request.getDescricao());
        produtoEntity.setQuantidade(request.getQuantidade());
        produtoEntity.setPreco(request.getPreco());

        ProdutoEntity atualizado = produtoRepository.save(produtoEntity);
    }
}
