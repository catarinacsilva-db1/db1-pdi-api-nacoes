package db1.pdi.api.nacao.repository;

import db1.pdi.api.nacao.entities.Nacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INacaoRepository extends JpaRepository<Nacao, Long> {
}
