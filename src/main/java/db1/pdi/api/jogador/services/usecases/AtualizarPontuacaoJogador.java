package db1.pdi.api.jogador.services.usecases;

import db1.pdi.api.infra.exceptions.EntidadeNaoEncontrada;
import db1.pdi.api.jogador.entities.Jogador;
import db1.pdi.api.jogador.repositories.IJogadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarPontuacaoJogador {

    @Autowired
    private IJogadorRepository repository;

    public Jogador executar(Long id, Long pontos) {
        Jogador jogador = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontrada("Jogador não encontrado"));

        jogador.atualizaPontos(pontos);
        return repository.save(jogador);
    }
}
