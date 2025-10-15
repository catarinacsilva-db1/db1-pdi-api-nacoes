package db1.pdi.api.jogador.controller.response;

import db1.pdi.api.nacao.controller.response.NacaoFromJogadorResponse;
import lombok.Builder;

@Builder
public record DetalheJogadorResponse(Long idJogador, String nomeJogador, String emailJogador, Long pontuacaoJogador, NacaoFromJogadorResponse nacao) {
}
