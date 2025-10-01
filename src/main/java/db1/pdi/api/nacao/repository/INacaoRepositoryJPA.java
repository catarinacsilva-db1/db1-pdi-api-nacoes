package db1.pdi.api.nacao.repository;

import db1.pdi.api.nacao.entities.NacaoEntityJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INacaoRepositoryJPA extends JpaRepository<NacaoEntityJPA, Long> {
}
