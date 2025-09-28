package br.com.gestorvendas.usecases.estoque;

import br.com.gestorvendas.dtos.ProdutoResponse;
import br.com.gestorvendas.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConsultarTodosProdutos {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoResponse> execute(){
        return produtoRepository.findAll().stream().map(ProdutoResponse::of).toList();
    }

}
