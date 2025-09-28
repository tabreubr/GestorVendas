package br.com.gestorvendas.dtos;
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
public class ReposicaoRequest {
    @NotNull
    private Integer produto;

    @NotNull
    @Min(value = 1, message = "A quantidade deve ser maior que zero")
    private Integer quantidade;
}
