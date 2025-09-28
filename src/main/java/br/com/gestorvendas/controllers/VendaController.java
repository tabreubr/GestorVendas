package br.com.gestorvendas.controllers;

import br.com.gestorvendas.dtos.ProdutoResponse;
import br.com.gestorvendas.dtos.VendaRequest;
import br.com.gestorvendas.dtos.VendaResponse;
import br.com.gestorvendas.usecases.venda.CancelarVenda;
import br.com.gestorvendas.usecases.venda.ListarVendas;
import br.com.gestorvendas.usecases.venda.RegistrarVenda;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendas")
public class VendaController {

    private final RegistrarVenda registrarVenda;

    private final CancelarVenda cancelarVenda;

    private final ListarVendas listarVendas;

    @GetMapping
    public ResponseEntity<List<VendaResponse>> listar() {
        return ResponseEntity.ok(listarVendas.execute());
    }


    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody VendaRequest request) {
        registrarVenda.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelar(@PathVariable Integer id){
        cancelarVenda.execute(id);
        return ResponseEntity.ok().build();

    }

}
