package db1.pdi.api.domain.nacao.services;


import db1.pdi.api.domain.jogador.JogadorDTO;
import db1.pdi.api.domain.nacao.entities.NacaoDTO;
import db1.pdi.api.domain.nacao.entities.NacaoDomain;
import db1.pdi.api.domain.nacao.entities.NacaoDomainFactory;
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


    public NacaoDTO cadastrarNacao(NacaoDTO dto) {
        return getDto(repository.save(NacaoDomainFactory.create(dto.nomeNacao())));
    }

    public Page<NacaoDTO> listarRankingNacoes(Pageable page) {
        return repository.buscarListaNacoes(page).map(nacao -> getDto(calculaPontos(nacao)));
    }

    public NacaoDTO retornarNacao(Long id) {
        return NacaoService.getDto(calculaPontos(retornaNacaoDomain(id)));
    }

    public NacaoDomain retornaNacaoDomain(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Nação não encontrada"));
    }

    public static NacaoDomain calculaPontos(NacaoDomain nacao){
        long pontos = nacao.getJogadores().stream()
                .mapToLong(j -> j.getPontuacaoJogador())
                .sum();
        nacao.setPontosNacao(pontos);
        return nacao;
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
