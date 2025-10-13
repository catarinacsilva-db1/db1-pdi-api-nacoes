package db1.pdi.api.nacao.services.usecases;

import db1.pdi.api.nacao.entities.Nacao;
import db1.pdi.api.nacao.repository.INacaoRepository;
import db1.pdi.api.nacao.services.usecases.utils.CalculaPontosNacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarNacaoPorId {

    @Autowired
    private INacaoRepository repository;
    @Autowired
    private BuscarNacaoEntidade buscarNacaoEntidade;

    public Nacao executar(Long id) {
        Nacao nacao = buscarNacaoEntidade.executar(id);
        return CalculaPontosNacao.executar(nacao);
    }
}
