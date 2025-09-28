package br.com.gestorvendas.repository;

import br.com.gestorvendas.model.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Integer> {
}
