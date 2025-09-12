package db1.pdi.api.domain.nacao.services;

import db1.pdi.api.domain.nacao.entities.NacaoDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INacaoService {
    NacaoDomain cadastrarNacao(NacaoDomain nacao);
    Page<NacaoDomain> listarRankingNacoes(Pageable page);
    NacaoDomain retornarNacao(Long id);
}
