package br.com.gestorvendas.gestorvendas.dtos;

import br.com.gestorvendas.gestorvendas.model.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoResponse {

    private String nome;
    private Double preco;

    public static ProdutoResponse of(ProdutoEntity entity){
        return new ProdutoResponse(entity.getNome(), entity.getPreco());
    }
}
