package db1.pdi.api.nacao.services.usecases;

import db1.pdi.api.nacao.entities.Nacao;
import db1.pdi.api.nacao.repository.INacaoRepository;
import db1.pdi.api.nacao.services.usecases.utils.CalculaPontosNacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ListarRankingNacoes {

    @Autowired
    private INacaoRepository repository;

    public List<Nacao> executar() {
        return repository.findAll()
                .stream()
                .map(CalculaPontosNacao::executar)
                .sorted(Comparator.comparingLong(Nacao::getPontosNacao).reversed())
                .toList();
    }
}
