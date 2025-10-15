package db1.pdi.api.nacao.dto;

import db1.pdi.api.jogador.dto.JogadorDTO;
import lombok.Builder;


import java.util.List;

@Builder
public record NacaoDTO (Long idNacao, String nomeNacao, List<JogadorDTO> jogadores, Long pontosNacao) {
}
