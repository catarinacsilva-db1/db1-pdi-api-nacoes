package db1.pdi.api.nacao.services.usecases;

import db1.pdi.api.nacao.entities.Nacao;
import db1.pdi.api.nacao.repository.INacaoRepository;
import db1.pdi.api.nacao.services.usecases.utils.CalculaPontosNacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarRankingNacoesUseCase {

    @Autowired
    private INacaoRepository repository;
    private CalculaPontosNacao calculaPontosNacao;

    public List<Nacao> executar() {
        return repository.findAll()
                .stream()
                .map(calculaPontosNacao::calcularPontos)
                .sorted((n1, n2) -> Long.compare(n2.getPontosNacao(), n1.getPontosNacao()))
                .toList();
    }
}
