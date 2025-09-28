package br.com.gestorvendas.controllers;

import br.com.gestorvendas.dtos.ProdutoRequest;
import br.com.gestorvendas.dtos.ProdutoResponse;
import br.com.gestorvendas.dtos.ReposicaoRequest;
import br.com.gestorvendas.usecases.estoque.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final AdicionarProduto adicionarProduto;

    private final ConsultarTodosProdutos consultarTodosProdutos;

    private final ConsultarProdutoPorNome consultarProdutoPorNome;

    private final AtualizarProduto atualizarProduto;

    private final RemoverProduto removerProduto;

    private final ReporEstoque reporEstoque;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody ProdutoRequest request) {
        adicionarProduto.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizarProduto(@PathVariable Integer id, @RequestBody ProdutoRequest request) {
        atualizarProduto.execute(id, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/repor")
    public ResponseEntity<ProdutoResponse> reporEstoque(@RequestBody ReposicaoRequest request) {
        reporEstoque.execute(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerProduto(@PathVariable Integer id) {
        removerProduto.execute(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> consulta(@RequestParam(required = false) String nome) {
        if (nome != null) {
            return ResponseEntity.ok(consultarProdutoPorNome.execute(nome));
        }
        return ResponseEntity.ok(consultarTodosProdutos.execute());
    }


}