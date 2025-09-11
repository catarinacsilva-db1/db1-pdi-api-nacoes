package db1.pdi.api.controller.jogador.response;

//podem ser adicionados outros campos vindos do Domain se necessário
public record DetalheJogadorResponse(Long idJogador, String nomeJogador, Long pontuacaoJogador) {
}
