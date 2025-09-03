package db1.pdi.api.services;

import db1.pdi.api.dto.GetNacaoDTO;
import db1.pdi.api.dto.NacaoDTO;
import db1.pdi.api.entities.entitiesJPA.NacaoEntityJPA;
import db1.pdi.api.repositories.INacaoRepositoryJPA;
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

    public Page<GetNacaoDTO> listarNacoes(Pageable page) {
        return repository.findAll(page).map(GetNacaoDTO::new);
    }

    public GetNacaoDTO retornarNacao(Long id) {
        return repository.findById(id).map(GetNacaoDTO::new)
                .orElseThrow(() -> new RuntimeException("Nação não encontrada"));//checar exceção
        //adicionar retorno de lista de jogadores da nação
    }



}
