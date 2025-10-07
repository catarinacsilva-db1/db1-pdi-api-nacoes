package db1.pdi.api.nacao.services;


import db1.pdi.api.jogador.dto.JogadorDTO;
import db1.pdi.api.nacao.dto.NacaoDTO;
import db1.pdi.api.nacao.entities.Nacao;
import db1.pdi.api.nacao.repository.INacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NacaoService implements INacaoService{

    @Autowired
    private INacaoRepository repository;


    public NacaoDTO cadastrarNacao(NacaoDTO dto) {
        Nacao nacao = new Nacao(null, dto.nomeNacao(), null);
        try {
            repository.save(nacao);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Nação com este nome já existe");
        }
        return getDto(nacao);
    }

    public List<NacaoDTO> listarRankingNacoes() {
        return repository.findAll()
                .stream()
                .map(NacaoService::calculaPontos)
                .map(NacaoService::getDto)
                .sorted((n1, n2) -> Long.compare(n2.pontosNacao(), n1.pontosNacao()))
                .toList();
    }

    public NacaoDTO retornarNacao(Long id) {
        Nacao nacao = retornarNacaoEntidade(id);
        return NacaoService.getDto(calculaPontos(nacao));
    }

    public Nacao retornarNacaoEntidade(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Nação não encontrada"));
    }

    public void deletarNacao(Long id) {
        repository.deleteById(id);
    }



    //utilitarios
    public static Nacao calculaPontos(Nacao nacao){
        long pontos = nacao.getJogadores().stream()
                .mapToLong(j -> j.getPontuacaoJogador())
                .sum();
        nacao.setPontosNacao(pontos);
        return nacao;
    }

    public static NacaoDTO getDto(Nacao nacao) {
        List<JogadorDTO> jogadoresDto = nacao.getJogadores() != null ?
                nacao.getJogadores().stream()
                .map(j -> new JogadorDTO(
                        j.getIdJogador(),
                        j.getNomeJogador(),
                        j.getPontuacaoJogador()))
                .toList()
                : List.of();

        return new NacaoDTO(
                nacao.getIdNacao(),
                nacao.getNomeNacao(),
                jogadoresDto,
                nacao.getPontosNacao());
    }
}
