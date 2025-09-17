package br.com.gestorvendas.gestorvendas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "A descrição é obrigatória")
    @Column(nullable = false, length = 255)
    private String descricao;

    @NotNull
    @Min(value = 0, message = "A quantidade não pode ser negativa")
    @Column(nullable = false)
    private Integer quantidade;

    @NotNull
    @Min(value = 0, message = "O preço não pode ser negativo")
    @Column(nullable = false)
    private Double preco;


    public void decrementarEstoque(int qtd) {
        if (this.quantidade >= qtd) {
            this.quantidade -= qtd;
        } else {
            throw new IllegalArgumentException("Estoque insuficiente para realizar a operação");
        }
    }

    public void reporEstoque(int qtd) {
        if (qtd > 0) {
            this.quantidade += qtd;
        } else {
            throw new IllegalArgumentException("A quantidade de reposição deve ser maior que zero");
        }
    }
}


