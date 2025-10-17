package db1.pdi.api.jogador.controller.response.utils;

import db1.pdi.api.jogador.controller.response.DetalheJogadorResponse;
import db1.pdi.api.jogador.controller.response.ListarJogadoresResponse;
import db1.pdi.api.nacao.controller.response.NacaoFromJogadorResponse;
import db1.pdi.api.nacao.controller.response.utils.NacaoResponseMapper;
import db1.pdi.api.jogador.dto.JogadorDTO;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JogadorResponseMapper {
    public static DetalheJogadorResponse toResponse(JogadorDTO jogador) {
        NacaoFromJogadorResponse nacaoResponse = NacaoResponseMapper.toResponseFromJogador(jogador.nacao());
        return DetalheJogadorResponse.builder()
                .idJogador(jogador.idJogador())
                .nomeJogador(jogador.nomeJogador())
                .emailJogador(jogador.emailJogador())
                .pontuacaoJogador(jogador.pontuacaoJogador())
                .nacao(nacaoResponse)
                .build();
    }

    public static List<ListarJogadoresResponse> toListJogadoresResponse(List<JogadorDTO> jogadores) {
        return jogadores.stream()
                .map(jogador -> ListarJogadoresResponse.builder()
                .idJogador(jogador.idJogador())
                .nomeJogador(jogador.nomeJogador())
                .pontuacaoJogador(jogador.pontuacaoJogador())
                .build())
                .toList();
    }
}
