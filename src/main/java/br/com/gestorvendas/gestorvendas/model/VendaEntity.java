package br.com.gestorvendas.gestorvendas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Min(value = 1, message = "A quantidade não pode ser negativa")
    @Column(nullable = false)
    private Integer quantidadeVendida;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutoEntity produtoEntity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuarioEntity;
}
