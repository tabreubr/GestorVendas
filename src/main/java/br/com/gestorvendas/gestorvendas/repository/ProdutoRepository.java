package br.com.gestorvendas.gestorvendas.repository;

import br.com.gestorvendas.gestorvendas.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {

    List<ProdutoEntity> findByNomeContainingIgnoreCase(String nome);
}
