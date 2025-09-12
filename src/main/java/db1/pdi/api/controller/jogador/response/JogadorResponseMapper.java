package db1.pdi.api.controller.jogador.response;

import db1.pdi.api.domain.jogador.entities.JogadorDomain;

public class JogadorResponseMapper {
    public static DetalheJogadorResponse toResponse(JogadorDomain jogador) {
        return new DetalheJogadorResponse(
                jogador.getIdJogador(),
                jogador.getNomeJogador(),
                jogador.getPontuacaoJogador());
    }
}
