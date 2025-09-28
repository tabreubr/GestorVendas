package br.com.gestorvendas.dtos;

import br.com.gestorvendas.model.ProdutoEntity;
import br.com.gestorvendas.model.UsuarioEntity;

import br.com.gestorvendas.model.VendaEntity;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendaResponse {

    private Integer id;
    private LocalDateTime dataHora;

    public static VendaResponse of(VendaEntity entity) {
        return VendaResponse.builder()
                .id(entity.getId())
                .dataHora(entity.getDataHora())
                .build();
    }
}
