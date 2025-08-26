package db1.pdi.api.repositories;

import db1.pdi.api.entities.entitiesJPA.NacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INacaoRepository extends JpaRepository<NacaoEntity, Long> {
}
