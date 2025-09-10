package db1.pdi.api.persistence.mappers;

import db1.pdi.api.domain.entities.JogadorDomain;
import db1.pdi.api.persistence.entitiesJPA.JogadorEntityJPA;

public class JogadorMapper {
    private JogadorDomain toDomain(JogadorEntityJPA entity) {
        return new JogadorDomain(
                entity.getIdJogador(),
                entity.getNomeJogador(),
                entity.getEmailJogador(),
                entity.getPontuacaoJogador(),
                entity.getNacaoId()
        );
    }

    private JogadorEntityJPA toJPA(JogadorDomain domain) {
        JogadorEntityJPA entity = new JogadorEntityJPA();
        entity.setIdJogador(domain.getIdJogador());
        entity.setNomeJogador(domain.getNomeJogador());
        entity.setEmailJogador(domain.getEmailJogador());
        entity.setPontuacaoJogador(domain.getPontuacaoJogador());
        //TODO entender como funciona essa conversão entre nacaoId e NacaoEntityJPA
        //entity.setNacaoId(domain.getIdNacao());

        entity.setAtivo(domain.isAtivo());
        return entity;
    }
}
