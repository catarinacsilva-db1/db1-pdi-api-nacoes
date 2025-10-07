package db1.pdi.api.nacao.dto;

import db1.pdi.api.jogador.dto.JogadorDTO;


import java.util.List;


public record NacaoDTO (Long idNacao, String nomeNacao, List<JogadorDTO> jogadores, Long pontosNacao) {

    public NacaoDTO(String nomeNacao) {
        this(null, nomeNacao, null, 0L);
    }
    public NacaoDTO(Long idNacao, String nomeNacao) {
        this(idNacao, nomeNacao, null, null);
    }
}
