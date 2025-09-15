package db1.pdi.api.persistence.nacao.JPA;

import db1.pdi.api.domain.nacao.entities.NacaoDomain;
import db1.pdi.api.domain.nacao.repositories.INacaoRepositoryDomain;
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
    public NacaoDomain save(NacaoDomain jogador) {
        return null;
    }

    @Override
    public Optional<NacaoDomain> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<NacaoDomain> buscarRankingNacoes(Pageable page) {
        return null;
    }


}
