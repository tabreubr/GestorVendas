package br.com.gestorvendas.exceptions;

public class ProdutoNaoEncontrado extends RuntimeException {

    public ProdutoNaoEncontrado(Integer id) {
        super("Produto " + id + " não encontrado." );
    }
}
