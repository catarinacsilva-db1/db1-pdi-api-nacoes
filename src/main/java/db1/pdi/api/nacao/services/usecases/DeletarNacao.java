package db1.pdi.api.nacao.services.usecases;

import db1.pdi.api.infra.exceptions.EntidadeNaoEncontrada;
import db1.pdi.api.nacao.repository.INacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarNacao {

    @Autowired
    private INacaoRepository repository;

    public void executar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntidadeNaoEncontrada("Nação não encontrada");
        }
        repository.deleteById(id);
    }
}
