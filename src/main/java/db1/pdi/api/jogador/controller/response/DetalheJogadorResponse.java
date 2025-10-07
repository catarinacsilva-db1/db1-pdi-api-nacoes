package db1.pdi.api.jogador.controller.response;

import db1.pdi.api.nacao.controller.response.NacaoFromJogadorResponse;

//podem ser adicionados outros campos vindos do Domain se necessário
public record DetalheJogadorResponse(Long idJogador, String nomeJogador, String emailJogador, Long pontuacaoJogador, NacaoFromJogadorResponse nacao) {
}
