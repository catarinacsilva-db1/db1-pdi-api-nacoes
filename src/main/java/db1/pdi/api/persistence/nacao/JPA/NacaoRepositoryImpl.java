package db1.pdi.api.persistence.nacao.JPA;

import db1.pdi.api.domain.nacao.entities.NacaoDomain;
import db1.pdi.api.domain.nacao.repositories.INacaoRepositoryDomain;
import db1.pdi.api.persistence.jogador.JPA.entities.JogadorEntityJPA;
import db1.pdi.api.persistence.jogador.JPA.mappers.JogadorMapperJPA;
import db1.pdi.api.persistence.nacao.JPA.entities.NacaoEntityJPA;
import db1.pdi.api.persistence.nacao.JPA.mappers.NacaoMapperJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class NacaoRepositoryImpl implements INacaoRepositoryDomain {

    @Autowired
    private INacaoRepositoryJPA jpa;

    @Override
    public NacaoDomain save(NacaoDomain nacao) {
        NacaoEntityJPA entity = NacaoMapperJPA.toJPA(nacao);
        NacaoEntityJPA saved = jpa.save(entity);
        return NacaoMapperJPA.toDomain(saved);
    }

    @Override
    public Optional<NacaoDomain> findById(Long id) {
        return jpa.findById(id)
                .map(NacaoMapperJPA::toDomain);
    }

    @Override
    public Page<NacaoDomain> buscarListaNacoes(Pageable page) {
        return jpa.findAll(page)
                .map(NacaoMapperJPA::toDomain);
    }
}
