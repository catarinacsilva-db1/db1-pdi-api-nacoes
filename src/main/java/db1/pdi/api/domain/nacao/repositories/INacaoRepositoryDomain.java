package db1.pdi.api.domain.nacao.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface INacaoRepositoryDomain {
    NacaoDomain save(NacaoDomain jogador);
    Optional<NacaoDomain> findById(Long id);
    Page<NacaoDomain> buscarListaNacoes(Pageable page);
}
