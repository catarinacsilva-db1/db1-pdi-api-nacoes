package db1.pdi.api.controller.nacao.response.utils;

import db1.pdi.api.controller.jogador.response.utils.JogadorResponseMapper;
import db1.pdi.api.controller.nacao.response.DetalheNacaoResponse;
import db1.pdi.api.controller.jogador.response.ListarJogadoresResponse;
import db1.pdi.api.controller.nacao.response.ListarNacaoResponse;
import db1.pdi.api.controller.nacao.response.NacaoFromJogadorResponse;
import db1.pdi.api.domain.nacao.entities.NacaoDomain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NacaoResponseMapper {

    public static DetalheNacaoResponse toResponse(NacaoDomain nacao) {
        List<ListarJogadoresResponse> jogadores = JogadorResponseMapper.toListJogadoresResponse(nacao.getJogadores());
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

    public static NacaoFromJogadorResponse toResponseFromJogador(NacaoDomain nacao) {
        return new NacaoFromJogadorResponse(
                nacao.getIdNacao(),
                nacao.getNomeNacao());
    }
}
