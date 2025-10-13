package br.com.gestorvendas.dtos;

import br.com.gestorvendas.model.ProdutoEntity;
import br.com.gestorvendas.model.UsuarioEntity;

import br.com.gestorvendas.model.VendaEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendaResponse {

    private Integer id;
    private LocalDateTime dataHora;
    private List<ItemVendaResponse> itens;
    private Double total;

    public static VendaResponse of(VendaEntity entity) {
        return VendaResponse.builder()
                .id(entity.getId())
                .dataHora(entity.getDataHora())
                .build();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ItemVendaResponse {
        private ProdutoResponse produto;
        private Integer quantidade;
    }
}
