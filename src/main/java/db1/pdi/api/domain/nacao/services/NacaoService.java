package db1.pdi.api.domain.nacao.services;


import db1.pdi.api.domain.jogador.JogadorDTO;
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


    public NacaoDTO cadastrarNacao(NacaoDTO nacao) {
        NacaoDomain nacao = repository.save(nacao);
        return getDto(nacao);
    }

    public Page<NacaoDTO> listarRankingNacoes(Pageable page) {
        Page<NacaoDomain> nacao = repository.buscarListaNacoes(page).map(pontosService::retornaPontosNacao);
        return nacao.map(this::getDto);
    }

    public NacaoDTO retornarNacao(Long id) {
        NacaoDomain nacao = repository.findById(id).orElseThrow(() -> new RuntimeException("Nação não encontrada"));
        pontosService.retornaPontosNacao(nacao);
        return new NacaoDTO(nacao.getIdNacao(),
                nacao.getNomeNacao(),
                nacao.getJogadores(),
                nacao.getPontosNacao());
    }

    public static NacaoDTO getDto(NacaoDomain nacao) {
        List<JogadorDTO> jogadoresDto = nacao.getJogadores().stream()
                .map(j -> new JogadorDTO(
                        j.idJogador(),
                        j.nomeJogador(),
                        j.pontuacaoJogador()))
                .toList();

        return new NacaoDTO(
                nacao.getIdNacao(),
                nacao.getNomeNacao(),
                jogadoresDto,
                nacao.getPontosNacao());
    }
}
