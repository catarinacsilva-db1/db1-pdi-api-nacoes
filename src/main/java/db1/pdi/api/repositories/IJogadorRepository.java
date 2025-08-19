package db1.pdi.api.repositories;

import db1.pdi.api.entities.Jogador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IJogadorRepository extends JpaRepository<Jogador, Long> {
    Page<Jogador> findAllByAtivoTrue(Pageable page);
}
