package db1.pdi.api.domain.jogador.services;

import db1.pdi.api.domain.jogador.repositories.IJogadorRepositoryDomain;
import db1.pdi.api.domain.nacao.entities.NacaoDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PontuacaoService implements IPontuacaoService{

    @Autowired
    private IJogadorRepositoryDomain repository;


    public NacaoDomain retornaPontosNacao(NacaoDomain nacao) {
        Long somaPontos = repository.somaPontosJogadoresPorNacao((nacao.getIdNacao()));
        if (somaPontos == null){
            nacao.setPontosNacao(0L);
        } else {
        nacao.setPontosNacao(somaPontos);
        }
        return nacao;
    }
}
