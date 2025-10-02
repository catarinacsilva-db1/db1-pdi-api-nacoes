package db1.pdi.api.nacao.services;

import db1.pdi.api.nacao.dto.NacaoDTO;
import db1.pdi.api.nacao.entities.Nacao;

import java.util.List;

public interface INacaoService {
    NacaoDTO cadastrarNacao(NacaoDTO nacao);
    List<NacaoDTO> listarRankingNacoes();
    NacaoDTO retornarNacao(Long id);
}
