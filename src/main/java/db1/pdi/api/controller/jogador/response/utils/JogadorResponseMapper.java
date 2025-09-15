package db1.pdi.api.controller.jogador.response.utils;

import db1.pdi.api.controller.jogador.response.DetalheJogadorResponse;
import db1.pdi.api.domain.jogador.entities.JogadorDomain;
import org.springframework.stereotype.Component;

@Component
public class JogadorResponseMapper {
    public static DetalheJogadorResponse toResponse(JogadorDomain jogador) {
        return new DetalheJogadorResponse(
                jogador.getIdJogador(),
                jogador.getNomeJogador(),
                jogador.getPontuacaoJogador());
    }
}
