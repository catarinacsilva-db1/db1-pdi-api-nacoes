package db1.pdi.api.nacao.services.usecases;

import db1.pdi.api.infra.exceptions.RegraDeNegocioException;
import db1.pdi.api.nacao.entities.Nacao;
import db1.pdi.api.nacao.repository.INacaoRepository;
import db1.pdi.api.nacao.services.usecases.utils.CalculaPontosNacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarNacaoPorIdUseCase {

    @Autowired
    private INacaoRepository repository;

    public Nacao executar(Long id) {
        Nacao nacao = repository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Nação não encontrada"));
        return CalculaPontosNacao.executar(nacao);
    }
}
