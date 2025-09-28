package br.com.gestorvendas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "itens_venda")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemVendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private VendaEntity venda;
}
