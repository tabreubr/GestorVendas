package br.com.gestorvendas.gestorvendas.dtos;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoRequest {


    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100)
    private String nome;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @NotNull
    @Min(value = 0, message = "A quantidade não pode ser negativa")
    private Integer quantidade;

    @NotNull
    @Min(value = 0, message = "O preço não pode ser negativo")
    private Double preco;
}
