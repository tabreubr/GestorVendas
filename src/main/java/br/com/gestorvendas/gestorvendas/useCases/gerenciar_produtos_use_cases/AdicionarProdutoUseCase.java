package br.com.gestorvendas.gestorvendas.useCases.gerenciar_produtos_use_cases;

import br.com.gestorvendas.gestorvendas.dtos.ProdutoRequest;
import br.com.gestorvendas.gestorvendas.model.ProdutoEntity;
import br.com.gestorvendas.gestorvendas.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdicionarProdutoUseCase {

    private final ProdutoRepository produtoRepository;

    public void execute(ProdutoRequest request){
        System.out.println("Insira os dados do produto: ");
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(request.getNome());
        produtoEntity.setDescricao(request.getDescricao());
        produtoEntity.setQuantidade(request.getQuantidade());
        produtoEntity.setPreco(request.getPreco());
        produtoRepository.save(produtoEntity);
    }
}
