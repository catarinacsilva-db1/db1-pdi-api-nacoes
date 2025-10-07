package db1.pdi.api.nacao.services.usecases;

import db1.pdi.api.infra.exceptions.RegraDeNegocioException;
import db1.pdi.api.nacao.repository.INacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarNacaoUseCase {

    @Autowired
    private INacaoRepository repository;

    public void executar(Long id) {
        if (!repository.existsById(id)) {
            throw new RegraDeNegocioException("Nação não encontrada");
        }
        repository.deleteById(id);
    }
}
