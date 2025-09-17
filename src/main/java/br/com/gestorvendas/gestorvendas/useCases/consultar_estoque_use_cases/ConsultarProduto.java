package br.com.gestorvendas.gestorvendas.useCases.consultar_estoque_use_cases;

import br.com.gestorvendas.gestorvendas.dtos.ProdutoResponse;
import br.com.gestorvendas.gestorvendas.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConsultarProduto {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoResponse> execute(String nome){
        return produtoRepository.findByNomeContainingIgnoreCase(nome).stream().map(ProdutoResponse::of).toList();
    }

}
