package db1.pdi.api.persistence;

import db1.pdi.api.domain.entities.JogadorDomain;
import db1.pdi.api.persistence.entitiesJPA.JogadorEntityJPA;
import db1.pdi.api.repositories.IJogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class JogadorRepositoryImpl implements IJogadorRepository {

    @Autowired
    private IJogadorRepositoryJPA jpaRepository;
    

    @Override
    public JogadorDomain save(JogadorDomain jogador) {
        JogadorEntityJPA entity = convertToJPA(jogador);
        JogadorEntityJPA saved = jpaRepository.save(entity);
        return convertToDomain(saved);
    }

    @Override
    public Optional<JogadorDomain> findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::convertToDomain);
    }

    @Override
    public Page<JogadorDomain> findAllByAtivoTrue(Pageable page) {
        return jpaRepository.findAllByAtivoTrue(page)
                .map(this::convertToDomain);
    }

    @Override
    public void delete(JogadorDomain jogador) {
        JogadorEntityJPA entity = convertToJPA(jogador);
        jpaRepository.delete(entity);
    }

    // Conversões isoladas na camada de infraestrutura

}
