package db1.pdi.api.jogador.services.usecases;

import db1.pdi.api.jogador.entities.Jogador;
import db1.pdi.api.jogador.repositories.IJogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarJogadorPorIdUseCase {

    @Autowired
    private IJogadorRepository repository;

    public Jogador executar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
    }
}
