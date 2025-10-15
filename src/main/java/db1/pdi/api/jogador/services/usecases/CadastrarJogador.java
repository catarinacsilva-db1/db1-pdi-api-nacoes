package db1.pdi.api.jogador.services.usecases;

import db1.pdi.api.infra.exceptions.DadosInvalidosException;
import db1.pdi.api.jogador.dto.JogadorDTO;
import db1.pdi.api.jogador.entities.Jogador;

import db1.pdi.api.jogador.repositories.IJogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarJogador {

    @Autowired
    private IJogadorRepository repository;

    public Jogador executar(JogadorDTO jogadorDTO) {
        if (repository.existsByEmailJogador(jogadorDTO.emailJogador())) {
            throw new DadosInvalidosException("Este email já está em uso");
        }
        Jogador jogador = new Jogador(jogadorDTO.nomeJogador(), jogadorDTO.emailJogador());
            return repository.save(jogador);
    }
}
