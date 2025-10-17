package db1.pdi.api.jogador.controller.response;

import lombok.Builder;

@Builder
public record ListarJogadoresResponse(Long idJogador, String nomeJogador, Long pontuacaoJogador) {
}
