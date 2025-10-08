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
        Jogador jogador = new Jogador(null, jogadorDTO.nomeJogador(), jogadorDTO.emailJogador(), 0L, null);
        try {
            return repository.save(jogador);
        } catch (RuntimeException e) {
            throw new DadosInvalidosException("Este email já está em uso");
        }
    }
}
