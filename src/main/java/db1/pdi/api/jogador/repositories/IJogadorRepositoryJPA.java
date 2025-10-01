package db1.pdi.api.jogador.repositories;

import db1.pdi.api.jogador.entities.JogadorEntityJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IJogadorRepositoryJPA extends JpaRepository<JogadorEntityJPA, Long> {
    Page<JogadorEntityJPA> findAllByAtivoTrue(Pageable page);
}
