package br.com.gestorvendas.usecases.estoque;

import br.com.gestorvendas.dtos.ProdutoResponse;
import br.com.gestorvendas.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConsultarProdutoPorNome {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoResponse> execute(String nome){
        return produtoRepository.findByNomeContainingIgnoreCase(nome).stream().map(ProdutoResponse::of).toList();
    }

}
