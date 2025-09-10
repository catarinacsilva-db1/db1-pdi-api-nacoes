package db1.pdi.api.persistence;

import db1.pdi.api.persistence.entitiesJPA.NacaoEntityJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INacaoRepositoryJPA extends JpaRepository<NacaoEntityJPA, Long> {
}
