package db1.pdi.api.jogador.services.usecases;

import db1.pdi.api.jogador.entities.Jogador;
import db1.pdi.api.jogador.repositories.IJogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarJogadoresUseCase {

    @Autowired
    private IJogadorRepository repository;

    public Page<Jogador> executar(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
