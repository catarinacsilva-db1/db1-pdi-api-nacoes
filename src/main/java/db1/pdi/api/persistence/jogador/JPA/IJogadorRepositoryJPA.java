package db1.pdi.api.persistence.jogador.JPA;

import db1.pdi.api.persistence.jogador.JPA.entities.JogadorEntityJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IJogadorRepositoryJPA extends JpaRepository<JogadorEntityJPA, Long> {
    Page<JogadorEntityJPA> findAllByAtivoTrue(Pageable page);
}
