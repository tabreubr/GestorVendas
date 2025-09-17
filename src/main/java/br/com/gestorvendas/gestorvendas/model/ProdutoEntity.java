package br.com.gestorvendas.gestorvendas.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produtos")
@Data
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 255)
    private String descricao;


    @Column(nullable = false)
    private Integer quantidade;


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


