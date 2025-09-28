package br.com.gestorvendas.usecases.estoque;

import br.com.gestorvendas.dtos.ProdutoRequest;
import br.com.gestorvendas.model.ProdutoEntity;
import br.com.gestorvendas.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdicionarProduto {

    private final ProdutoRepository produtoRepository;

    public void execute(ProdutoRequest request){
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(request.getNome());
        produtoEntity.setDescricao(request.getDescricao());
        produtoEntity.setQuantidade(request.getQuantidade());
        produtoEntity.setPreco(request.getPreco());
        produtoRepository.save(produtoEntity);
    }
}
