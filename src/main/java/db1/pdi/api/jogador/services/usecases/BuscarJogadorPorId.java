package db1.pdi.api.jogador.services.usecases;

import db1.pdi.api.infra.exceptions.EntidadeNaoEncontrada;
import db1.pdi.api.jogador.entities.Jogador;
import db1.pdi.api.jogador.repositories.IJogadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarJogadorPorId {

    @Autowired
    private IJogadorRepository repository;

    public Jogador executar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontrada("Jogador não encontrado"));
    }
}
