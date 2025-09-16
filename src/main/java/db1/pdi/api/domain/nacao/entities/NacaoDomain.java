package db1.pdi.api.domain.nacao.entities;

import db1.pdi.api.domain.jogador.entities.JogadorDomain;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class NacaoDomain {
    private final Long idNacao;
    private final String nomeNacao;
    private final List<JogadorDomain> jogadores;

    @Setter
    private Long pontosNacao;

    public NacaoDomain(Long idNacao, String nomeNacao, List jogadores, Long pontosNacao) {
        this.idNacao = idNacao;
        this.nomeNacao = nomeNacao;
        this.jogadores = jogadores;
        this.pontosNacao = pontosNacao;
    }
}
