package db1.pdi.api.nacao.controller.response.utils;

import db1.pdi.api.jogador.controller.response.utils.JogadorResponseMapper;
import db1.pdi.api.nacao.controller.response.DetalheNacaoResponse;
import db1.pdi.api.jogador.controller.response.ListarJogadoresResponse;
import db1.pdi.api.nacao.controller.response.ListarNacaoResponse;
import db1.pdi.api.nacao.controller.response.NacaoFromJogadorResponse;
import db1.pdi.api.nacao.dto.NacaoDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NacaoResponseMapper {

    public static DetalheNacaoResponse toResponse(NacaoDTO nacao) {
        List<ListarJogadoresResponse> jogadores = JogadorResponseMapper.toListJogadoresResponse(nacao.jogadores());
        return DetalheNacaoResponse.builder()
                .idNacao(nacao.idNacao())
                .nomeNacao(nacao.nomeNacao())
                .jogadores(jogadores)
                .build();
    }

    public static ListarNacaoResponse toResponseList(NacaoDTO nacao) {
        return ListarNacaoResponse.builder()
                .idNacao(nacao.idNacao())
                .nomeNacao(nacao.nomeNacao())
                .pontosNacao(nacao.pontosNacao())
                .build();
    }

    public static NacaoFromJogadorResponse toResponseFromJogador(NacaoDTO nacao) {
        return NacaoFromJogadorResponse.builder()
                .idNacao(nacao.idNacao())
                .nomeNacao(nacao.nomeNacao())
                .build();
    }
}
