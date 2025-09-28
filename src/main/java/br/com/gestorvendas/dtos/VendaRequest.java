package br.com.gestorvendas.dtos;

import br.com.gestorvendas.model.ProdutoEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendaRequest {

    @NotNull
    private List<ItemVenda> itens;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ItemVenda {

        @NotNull
        private Integer produto;

        @NotNull
        @Min(value = 1, message = "A quantidade deve ser maior que 1")
        private Integer quantidade;
    }



}
