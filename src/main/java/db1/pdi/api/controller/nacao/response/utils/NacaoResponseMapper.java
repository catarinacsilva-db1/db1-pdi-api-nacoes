package db1.pdi.api.controller.nacao.response.utils;

import db1.pdi.api.controller.jogador.response.utils.JogadorResponseMapper;
import db1.pdi.api.controller.nacao.response.DetalheNacaoResponse;
import db1.pdi.api.controller.jogador.response.ListarJogadoresResponse;
import db1.pdi.api.controller.nacao.response.ListarNacaoResponse;
import db1.pdi.api.controller.nacao.response.NacaoFromJogadorResponse;
import db1.pdi.api.domain.nacao.entities.NacaoDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NacaoResponseMapper {

    public static DetalheNacaoResponse toResponse(NacaoDTO nacao) {
        List<ListarJogadoresResponse> jogadores = JogadorResponseMapper.toListJogadoresResponse(nacao.jogadores());
        return new DetalheNacaoResponse(
                nacao.idNacao(),
                nacao.nomeNacao(),
                jogadores);
    }

    public static ListarNacaoResponse toResponseList(NacaoDTO nacao) {
        return new ListarNacaoResponse(
                nacao.idNacao(),
                nacao.nomeNacao(),
                nacao.pontosNacao());
    }

    public static NacaoFromJogadorResponse toResponseFromJogador(NacaoDTO nacao) {
        return new NacaoFromJogadorResponse(
                nacao.idNacao(),
                nacao.nomeNacao());
    }
}
