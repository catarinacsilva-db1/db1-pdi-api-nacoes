package db1.pdi.api.persistence.jogador.JPA.mappers;

import db1.pdi.api.domain.jogador.entities.JogadorDomain;
import db1.pdi.api.domain.jogador.entities.JogadorDomainFactory;
import db1.pdi.api.domain.nacao.entities.NacaoDTO;
import db1.pdi.api.persistence.jogador.JPA.entities.JogadorEntityJPA;
import db1.pdi.api.persistence.nacao.JPA.entities.NacaoEntityJPA;
import db1.pdi.api.persistence.nacao.JPA.mappers.NacaoMapperJPA;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JogadorMapperJPA {

    public static JogadorDomain toDomain(JogadorEntityJPA entity) {
        NacaoDTO nacao = entity.getNacao() != null ?
                NacaoMapperJPA.toJogadorDomain(entity.getNacao()) : null;

        return new JogadorDomain(
                entity.getIdJogador(),
                entity.getNomeJogador(),
                entity.getEmailJogador(),
                entity.getPontuacaoJogador(),
                nacao
        );
    }

    public static List<JogadorDomain> toDomainListJogadoresJPA(List<JogadorEntityJPA> jogadores) {
        return jogadores.stream()
                .map(jogador -> JogadorDomainFactory.toListJogadores(
                        jogador.getIdJogador(),
                        jogador.getNomeJogador(),
                        jogador.getPontuacaoJogador()))
                .toList();
    }

    public static JogadorEntityJPA toJPA(JogadorDomain domain) {
        NacaoEntityJPA nacao = domain.getNacao() != null ?
                NacaoMapperJPA.toJPA(domain.getNacao()) : null;
        return new JogadorEntityJPA(
                domain.getIdJogador(),
                domain.getNomeJogador(),
                domain.getEmailJogador(),
                domain.getPontuacaoJogador(),
                nacao,
                domain.isAtivo()
        );
    }
}
