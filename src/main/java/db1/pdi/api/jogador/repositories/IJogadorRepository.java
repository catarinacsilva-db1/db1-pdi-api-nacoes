package db1.pdi.api.jogador.repositories;

import db1.pdi.api.jogador.entities.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IJogadorRepository extends JpaRepository<Jogador, Long> {
}
