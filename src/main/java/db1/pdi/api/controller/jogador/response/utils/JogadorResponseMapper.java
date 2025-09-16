package db1.pdi.api.controller.jogador.response.utils;

import db1.pdi.api.controller.jogador.response.DetalheJogadorResponse;
import db1.pdi.api.controller.jogador.response.ListarJogadoresResponse;
import db1.pdi.api.controller.nacao.response.ListarNacaoResponse;
import db1.pdi.api.controller.nacao.response.NacaoFromJogadorResponse;
import db1.pdi.api.controller.nacao.response.utils.NacaoResponseMapper;
import db1.pdi.api.domain.jogador.entities.JogadorDomain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JogadorResponseMapper {
    public static DetalheJogadorResponse toResponse(JogadorDomain jogador) {
        NacaoFromJogadorResponse nacaoResponse;

        if (jogador.getNacao() != null) {
            nacaoResponse = NacaoResponseMapper.toResponseFromJogador(jogador.getNacao());
        } else {
            nacaoResponse = new NacaoFromJogadorResponse(
                    null,
                    "Sem nação"
            );
        }

        return new DetalheJogadorResponse(
                jogador.getIdJogador(),
                jogador.getNomeJogador(),
                jogador.getEmailJogador(),
                jogador.getPontuacaoJogador(),
                nacaoResponse);
    }

    public static List<ListarJogadoresResponse> toListJogadoresResponse(List<JogadorDomain> jogadores) {
        return jogadores.stream()
                .map(jogador -> new ListarJogadoresResponse(
                        jogador.getIdJogador(),
                        jogador.getNomeJogador(),
                        jogador.getPontuacaoJogador()))
                .toList();
    }
}
