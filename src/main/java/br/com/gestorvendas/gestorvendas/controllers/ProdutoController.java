package br.com.gestorvendas.gestorvendas.controllers;

import br.com.gestorvendas.gestorvendas.dtos.ProdutoRequest;
import br.com.gestorvendas.gestorvendas.dtos.ProdutoResponse;
import br.com.gestorvendas.gestorvendas.useCases.consultar_estoque_use_cases.ConsultarProduto;
import br.com.gestorvendas.gestorvendas.useCases.gerenciar_produtos_use_cases.AdicionarProdutoUseCase;
import br.com.gestorvendas.gestorvendas.useCases.consultar_estoque_use_cases.ListarEstoque;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("produtos")
public class ProdutoController {

    private final AdicionarProdutoUseCase adicionarProduto;

    private final ListarEstoque listarEstoque;

    private final ConsultarProduto consultarProduto;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody ProdutoRequest request) {
        adicionarProduto.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> consulta(){
        var produtos = listarEstoque.execute();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<ProdutoResponse>> findByNome(@RequestParam String nome){
        return ResponseEntity.ok(consultarProduto.execute(nome));
    }

}