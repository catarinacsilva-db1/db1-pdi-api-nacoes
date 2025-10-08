package db1.pdi.api.nacao.services.usecases;

import db1.pdi.api.infra.exceptions.DadosInvalidosException;
import db1.pdi.api.nacao.dto.NacaoDTO;
import db1.pdi.api.nacao.entities.Nacao;
import db1.pdi.api.nacao.repository.INacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarNacao {

    @Autowired
    private INacaoRepository repository;

    public Nacao executar(NacaoDTO dto) {
        Nacao nacao = new Nacao(null, dto.nomeNacao(), null);
        try {
            return repository.save(nacao);
        } catch (DadosInvalidosException e) {
            throw new DadosInvalidosException("Nação com este nome já existe");
        }
    }
}
