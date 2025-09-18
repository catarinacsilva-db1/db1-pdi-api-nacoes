package db1.pdi.api.domain.nacao.services;


import db1.pdi.api.domain.jogador.JogadorDTO;
import db1.pdi.api.domain.nacao.entities.NacaoDomain;
import db1.pdi.api.domain.nacao.entities.NacaoDomainFactory;
import db1.pdi.api.domain.pontuacao.IPontuacaoService;
import db1.pdi.api.domain.nacao.entities.NacaoDTO;
import db1.pdi.api.domain.nacao.repositories.INacaoRepositoryDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NacaoService implements INacaoService{

    @Autowired
    private INacaoRepositoryDomain repository;

    @Autowired
    private IPontuacaoService pontosService;


    public NacaoDTO cadastrarNacao(NacaoDTO dto) {
        NacaoDomain nacao = NacaoDomainFactory.create(dto.nomeNacao());
        return getDto(repository.save(nacao));
    }

    public Page<NacaoDTO> listarRankingNacoes(Pageable page) {
        Page<NacaoDomain> nacao = repository.buscarListaNacoes(page).map(pontosService::retornaPontosNacao);
        return nacao.map(NacaoService::getDto);
    }

    public NacaoDTO retornarNacao(Long id) {
        NacaoDomain nacao = retornaNacaoDomain(id);
        pontosService.retornaPontosNacao(nacao);
        return NacaoService.getDto(nacao);
    }

    public NacaoDomain retornaNacaoDomain(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Nação não encontrada"));
    }

    public static NacaoDTO getDto(NacaoDomain nacao) {
        List<JogadorDTO> jogadoresDto = nacao.getJogadores().stream()
                .map(j -> new JogadorDTO(
                        j.getIdJogador(),
                        j.getNomeJogador(),
                        j.getPontuacaoJogador()))
                .toList();

        return new NacaoDTO(
                nacao.getIdNacao(),
                nacao.getNomeNacao(),
                jogadoresDto,
                nacao.getPontosNacao());
    }
}
