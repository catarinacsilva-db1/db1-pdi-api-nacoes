package db1.pdi.api.controller.jogador.response;

import db1.pdi.api.controller.nacao.response.NacaoFromJogadorResponse;

//podem ser adicionados outros campos vindos do Domain se necessário
public record DetalheJogadorResponse(Long idJogador, String nomeJogador, String emailJogador, Long pontuacaoJogador, NacaoFromJogadorResponse nacao) {
}
