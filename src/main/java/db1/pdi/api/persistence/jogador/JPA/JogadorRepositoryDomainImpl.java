package db1.pdi.api.persistence.jogador.JPA;

import db1.pdi.api.domain.jogador.entities.JogadorDomain;
import db1.pdi.api.persistence.jogador.JPA.entities.JogadorEntityJPA;
import db1.pdi.api.persistence.jogador.JPA.mappers.JogadorMapperJPA;
import db1.pdi.api.domain.jogador.repositories.IJogadorRepositoryDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JogadorRepositoryDomainImpl implements IJogadorRepositoryDomain {

    @Autowired
    private IJogadorRepositoryJPA jpa;

    @Override
    public JogadorDomain save(JogadorDomain jogador) {
        JogadorEntityJPA entity = JogadorMapperJPA.toJPA(jogador);
        JogadorEntityJPA saved = jpa.save(entity);
        return JogadorMapperJPA.toDomain(saved);
    }

    @Override
    public Optional<JogadorDomain> findById(Long id) {
        return jpa.findById(id)
                .map(JogadorMapperJPA::toDomain);
    }

    @Override
    public Page<JogadorDomain> findAllByAtivoTrue(Pageable page) {
        return jpa.findAllByAtivoTrue(page)
                .map(JogadorMapperJPA::toDomain);
    }

    @Override
    public void delete(JogadorDomain jogador) {
        JogadorEntityJPA entity = JogadorMapperJPA.toJPA(jogador);
        jpa.delete(entity);
    }

    @Override
    public JogadorDomain getReferenceById(Long id) {
       JogadorEntityJPA entity = jpa.getReferenceById(id);
       return JogadorMapperJPA.toDomain(entity);
    }
}
