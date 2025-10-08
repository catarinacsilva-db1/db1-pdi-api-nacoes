package db1.pdi.api.nacao.services.usecases;

import db1.pdi.api.infra.exceptions.EntidadeNaoEncontrada;
import db1.pdi.api.nacao.entities.Nacao;
import db1.pdi.api.nacao.repository.INacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarNacaoEntidade {

    @Autowired
    private INacaoRepository repository;

    public Nacao executar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontrada("Nação não encontrada"));
    }
}
