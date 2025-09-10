package db1.pdi.api.persistence;

import db1.pdi.api.domain.entities.JogadorDomain;
import db1.pdi.api.persistence.entitiesJPA.JogadorEntityJPA;
import db1.pdi.api.persistence.mappers.JogadorMapper;
import db1.pdi.api.repositories.IJogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JogadorRepositoryImpl implements IJogadorRepository {

    @Autowired
    private IJogadorRepositoryJPA jpaRepository;

    @Override
    public JogadorDomain save(JogadorDomain jogador) {
        JogadorEntityJPA entity = JogadorMapper.toJPA(jogador);
        JogadorEntityJPA saved = jpaRepository.save(entity);
        return JogadorMapper.toDomain(saved);
    }

    @Override
    public Optional<JogadorDomain> findById(Long id) {
        return jpaRepository.findById(id)
                .map(JogadorMapper::toDomain);
    }

    @Override
    public Page<JogadorDomain> findAllByAtivoTrue(Pageable page) {
        return jpaRepository.findAllByAtivoTrue(page)
                .map(JogadorMapper::toDomain);
    }

    @Override
    public void delete(JogadorDomain jogador) {
        JogadorEntityJPA entity = JogadorMapper.toJPA(jogador);
        jpaRepository.delete(entity);
    }

    @Override
    public JogadorDomain getReferenceById(Long id) {
       JogadorEntityJPA entity = jpaRepository.getReferenceById(id);
       return JogadorMapper.toDomain(entity);
    }
}
