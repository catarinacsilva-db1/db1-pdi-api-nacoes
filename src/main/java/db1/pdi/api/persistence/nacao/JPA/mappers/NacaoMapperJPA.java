package db1.pdi.api.persistence.nacao.JPA.mappers;


import db1.pdi.api.domain.jogador.entities.JogadorDomain;
import db1.pdi.api.domain.nacao.entities.NacaoDomain;
import db1.pdi.api.domain.nacao.entities.NacaoDomainFactory;
import db1.pdi.api.persistence.jogador.JPA.entities.JogadorEntityJPA;
import db1.pdi.api.persistence.jogador.JPA.mappers.JogadorMapperJPA;
import db1.pdi.api.persistence.nacao.JPA.entities.NacaoEntityJPA;

import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class NacaoMapperJPA {

    public static NacaoDomain toDomain(NacaoEntityJPA nacao) {
        List<JogadorDomain> listaJogadores = nacao.getJogadores()  != null ?
                nacao.getJogadores().stream()
                .map(JogadorMapperJPA::toDomain)
                .toList() : null;

        return NacaoDomainFactory.fromJPA(
                nacao.getIdNacao(),
                nacao.getNomeNacao(),
                listaJogadores);
    }

    public static NacaoDomain toJogadorDomain(NacaoEntityJPA nacao) {
        return NacaoDomainFactory.toJogadorDomain(
                nacao.getIdNacao(),
                nacao.getNomeNacao()
        );
    }

    public static NacaoEntityJPA toJPA(NacaoDomain domain) {
        List<JogadorEntityJPA> jogadoresJPA = domain.getJogadores() != null ?
        domain.getJogadores().stream()
                .map(JogadorMapperJPA::toJPA)
                .toList(): null;

        return new NacaoEntityJPA(
                domain.getIdNacao(),
                domain.getNomeNacao(),
                jogadoresJPA
        );
    }



}
