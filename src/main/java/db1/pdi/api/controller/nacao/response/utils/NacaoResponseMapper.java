package db1.pdi.api.controller.nacao.response.utils;

import db1.pdi.api.controller.nacao.response.DetalheNacaoResponse;
import db1.pdi.api.controller.nacao.response.ListarJogadoresResponse;
import db1.pdi.api.controller.nacao.response.ListarNacaoResponse;
import db1.pdi.api.domain.jogador.entities.JogadorDomain;
import db1.pdi.api.domain.nacao.entities.NacaoDomain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NacaoResponseMapper {

    public static DetalheNacaoResponse toResponse(NacaoDomain nacao) {
        List<ListarJogadoresResponse> jogadores = toListJogadoresResponse(nacao.getJogadores());
        return new DetalheNacaoResponse(
                nacao.getIdNacao(),
                nacao.getNomeNacao(),
                jogadores);
    }

    public static ListarNacaoResponse toResponseList(NacaoDomain nacao) {
        return new ListarNacaoResponse(
                nacao.getIdNacao(),
                nacao.getNomeNacao(),
                nacao.getPontosNacao());
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
