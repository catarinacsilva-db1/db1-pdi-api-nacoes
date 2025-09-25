package db1.pdi.api.domain.jogador.repositories;

import db1.pdi.api.domain.jogador.entities.JogadorDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface IJogadorRepositoryDomain {
    JogadorDomain save(JogadorDomain jogador);
    Optional<JogadorDomain> findById(Long id);
    Page<JogadorDomain> findAllByAtivoTrue(Pageable page);
    void delete(JogadorDomain jogador);
    JogadorDomain getReferenceById(Long id);
}