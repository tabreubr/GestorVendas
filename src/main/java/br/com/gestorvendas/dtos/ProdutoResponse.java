package br.com.gestorvendas.dtos;

import br.com.gestorvendas.model.ProdutoEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoResponse {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer quantidade;
    private Double preco;

    public ProdutoResponse(ProdutoEntity atualizado) {
    }


    public static ProdutoResponse of(ProdutoEntity entity){
        return new ProdutoResponse(entity.getId(), entity.getNome()
                , entity.getDescricao(), entity.getQuantidade(), entity.getPreco());
    }
}
