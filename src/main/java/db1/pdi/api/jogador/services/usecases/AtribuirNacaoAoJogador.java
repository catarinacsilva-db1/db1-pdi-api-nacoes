package db1.pdi.api.jogador.services.usecases;

import db1.pdi.api.jogador.entities.Jogador;
import db1.pdi.api.jogador.repositories.IJogadorRepository;
import db1.pdi.api.nacao.services.usecases.BuscarNacaoEntidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtribuirNacaoAoJogador {

    @Autowired
    private IJogadorRepository repository;
    @Autowired
    private BuscarNacaoEntidade buscarNacaoEntidade;
    @Autowired
    private BuscarJogadorPorId buscarJogadorPorId;

    public Jogador executar(Long idJogador, Long idNacao) {
        Jogador jogador = buscarJogadorPorId.executar(idJogador);

        jogador.atribuirNacao(buscarNacaoEntidade.executar(idNacao));
        return repository.save(jogador);
    }
}

