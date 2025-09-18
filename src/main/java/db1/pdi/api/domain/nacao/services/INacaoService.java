package db1.pdi.api.domain.nacao.services;

import db1.pdi.api.domain.nacao.entities.NacaoDTO;
import db1.pdi.api.domain.nacao.entities.NacaoDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INacaoService {
    NacaoDTO cadastrarNacao(NacaoDTO nacao);
    Page<NacaoDTO> listarRankingNacoes(Pageable page);
    NacaoDTO retornarNacao(Long id);
    NacaoDomain retornaNacaoDomain(Long id);
}
