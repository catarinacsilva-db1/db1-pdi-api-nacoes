package db1.pdi.api.controller.jogador.response.utils;

import db1.pdi.api.controller.jogador.response.DetalheJogadorResponse;
import db1.pdi.api.controller.jogador.response.ListarJogadoresResponse;
import db1.pdi.api.controller.nacao.response.NacaoFromJogadorResponse;
import db1.pdi.api.controller.nacao.response.utils.NacaoResponseMapper;
import db1.pdi.api.domain.jogador.JogadorDTO;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JogadorResponseMapper {
    public static DetalheJogadorResponse toResponse(JogadorDTO jogador) {
        NacaoFromJogadorResponse nacaoResponse = NacaoResponseMapper.toResponseFromJogador(jogador.nacao());
        return new DetalheJogadorResponse(
                jogador.idJogador(),
                jogador.nomeJogador(),
                jogador.emailJogador(),
                jogador.pontuacaoJogador(),
                nacaoResponse);
    }

    public static List<ListarJogadoresResponse> toListJogadoresResponse(List<JogadorDTO> jogadores) {
        return jogadores.stream()
                .map(jogador -> new ListarJogadoresResponse(
                        jogador.idJogador(),
                        jogador.nomeJogador(),
                        jogador.pontuacaoJogador()))
                .toList();
    }
}
