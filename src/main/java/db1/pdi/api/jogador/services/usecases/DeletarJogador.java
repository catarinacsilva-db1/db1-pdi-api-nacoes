package db1.pdi.api.jogador.services.usecases;

import db1.pdi.api.infra.exceptions.EntidadeNaoEncontradaException;
import db1.pdi.api.jogador.repositories.IJogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarJogador {

    @Autowired
    private IJogadorRepository repository;

    public void executar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Jogador não encontrado");
        }
        repository.deleteById(id);
    }
}
