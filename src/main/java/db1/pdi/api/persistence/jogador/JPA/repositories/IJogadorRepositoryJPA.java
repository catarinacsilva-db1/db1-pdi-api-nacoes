package db1.pdi.api.persistence.jogador.JPA.repositories;

import db1.pdi.api.persistence.jogador.JPA.entities.JogadorEntityJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IJogadorRepositoryJPA extends JpaRepository<JogadorEntityJPA, Long> {
    Page<JogadorEntityJPA> findAllByAtivoTrue(Pageable page);
    boolean existsByEmailJogador(String email);

    @Query("SELECT SUM(j.pontuacaoJogador) FROM jogador j WHERE j.nacao.idNacao = :idNacao")
    Long somaPontosJogadoresPorNacao(@Param("idNacao") Long idNacao);
}
