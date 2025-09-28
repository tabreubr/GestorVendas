package br.com.gestorvendas.usecases.estoque;

import br.com.gestorvendas.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoverProduto {

    private final ProdutoRepository produtoRepository;

    public void execute(Integer id){
        produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível deletar, o " + id + "não existe"));
        produtoRepository.deleteById(id);
    }
}
