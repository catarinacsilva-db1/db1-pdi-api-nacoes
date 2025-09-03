package db1.pdi.api.repositories;

import db1.pdi.api.entities.entitiesJPA.NacaoEntityJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INacaoRepositoryJPA extends JpaRepository<NacaoEntityJPA, Long> {
}
