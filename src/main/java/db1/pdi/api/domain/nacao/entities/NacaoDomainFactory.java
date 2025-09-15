package db1.pdi.api.domain.nacao.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NacaoDomainFactory {

    public static NacaoDomain create(String nomeNacao) {
        return new NacaoDomain(null, nomeNacao, new ArrayList<>(), 0L);
    }

    public static NacaoDomain fromJPA(Long idNacao, String nomeNacao, List jogadores) {
        return new NacaoDomain(idNacao, nomeNacao, jogadores, null);
    }

    public static NacaoDomain toRanking(Long idNacao, String nomeNacao, Long pontosNacao) {
        return new NacaoDomain(idNacao, nomeNacao, null, pontosNacao);
    }

    public static NacaoDomain toJogadorDomain(Long idNacao, String nomeNacao) {
        return new NacaoDomain(idNacao, nomeNacao, null, null);
    }
}
