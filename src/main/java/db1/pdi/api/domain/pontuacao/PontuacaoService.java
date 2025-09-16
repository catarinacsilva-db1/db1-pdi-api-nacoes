package db1.pdi.api.domain.pontuacao;

import db1.pdi.api.domain.jogador.repositories.IJogadorRepositoryDomain;
import db1.pdi.api.domain.nacao.entities.NacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PontuacaoService implements IPontuacaoService {

    @Autowired
    private IJogadorRepositoryDomain repository;


    public NacaoDTO retornaPontosNacao(NacaoDTO nacao) {
        Long somaPontos = repository.somaPontosJogadoresPorNacao((nacao.getIdNacao()));
        nacao.setPontosNacao(Objects.requireNonNullElse(somaPontos, 0L));
        return nacao;
    }
}
