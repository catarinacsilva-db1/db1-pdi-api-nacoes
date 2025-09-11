package db1.pdi.api.persistence.nacao.JPA;

import db1.pdi.api.persistence.nacao.JPA.entities.NacaoEntityJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INacaoRepositoryJPA extends JpaRepository<NacaoEntityJPA, Long> {
}
