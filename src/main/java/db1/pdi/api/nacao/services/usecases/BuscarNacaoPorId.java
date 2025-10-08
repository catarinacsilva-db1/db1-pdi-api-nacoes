package db1.pdi.api.nacao.services.usecases;

import db1.pdi.api.infra.exceptions.EntidadeNaoEncontrada;
import db1.pdi.api.nacao.entities.Nacao;
import db1.pdi.api.nacao.repository.INacaoRepository;
import db1.pdi.api.nacao.services.usecases.utils.CalculaPontosNacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarNacaoPorId {

    @Autowired
    private INacaoRepository repository;

    public Nacao executar(Long id) {
        Nacao nacao = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontrada("Nação não encontrada"));
        return CalculaPontosNacao.executar(nacao);
    }
}
