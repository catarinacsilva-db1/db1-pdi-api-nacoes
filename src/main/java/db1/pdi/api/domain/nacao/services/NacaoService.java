package db1.pdi.api.domain.nacao.services;



import db1.pdi.api.domain.jogador.services.IPontuacaoService;
import db1.pdi.api.domain.jogador.services.PontuacaoService;
import db1.pdi.api.domain.nacao.entities.NacaoDomain;
import db1.pdi.api.domain.nacao.repositories.INacaoRepositoryDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NacaoService implements INacaoService{

    @Autowired
    private INacaoRepositoryDomain repository;

    @Autowired
    private IPontuacaoService pontosService;


    public NacaoDomain cadastrarNacao(NacaoDomain nacao) {
        return repository.save(nacao);
    }

public Page<NacaoDomain> listarRankingNacoes(Pageable page) {
    return repository.buscarListaNacoes(page).map(pontosService::retornaPontosNacao);
}

    public NacaoDomain retornarNacao(Long id) {
        NacaoDomain nacao = repository.findById(id).orElseThrow(() -> new RuntimeException("Nação não encontrada") );
    return pontosService.retornaPontosNacao(nacao);}
}
