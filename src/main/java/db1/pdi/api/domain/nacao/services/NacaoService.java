package db1.pdi.api.domain.nacao.services;

import db1.pdi.api.controller.nacao.response.DetalheNacaoResponse;
import db1.pdi.api.domain.jogador.services.IJogadorService;
import db1.pdi.api.dto.NacaoDTO;
import db1.pdi.api.persistence.nacao.JPA.entities.NacaoEntityJPA;
import db1.pdi.api.persistence.nacao.JPA.INacaoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NacaoService implements INacaoService{

    @Autowired
    INacaoRepositoryJPA repository;
    IJogadorService jogadorService;

    public void cadastrarNacao(NacaoDTO nacaoDTO) {
        repository.save((new NacaoEntityJPA(nacaoDTO)));
    }

    public Page<DetalheNacaoResponse> listarNacoes(Pageable page) {
        return repository.findAll(page).map(DetalheNacaoResponse::new);
    }

    public DetalheNacaoResponse retornarNacao(Long id) {
        return repository.findById(id).map(DetalheNacaoResponse::new)
                .orElseThrow(() -> new RuntimeException("Nação não encontrada"));//checar exceção
        //adicionar retorno de lista de jogadores da nação
    }



}
