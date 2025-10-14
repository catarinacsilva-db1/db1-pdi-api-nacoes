package db1.pdi.api.nacao.services;


import db1.pdi.api.jogador.dto.JogadorDTO;
import db1.pdi.api.nacao.dto.NacaoDTO;
import db1.pdi.api.nacao.entities.Nacao;
import db1.pdi.api.nacao.repository.INacaoRepository;
import db1.pdi.api.nacao.services.usecases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NacaoService implements INacaoService{

    @Autowired
    private INacaoRepository repository;

    @Autowired
    private CadastrarNacao cadastrarNacao;
    @Autowired
    private ListarRankingNacoes listarRanking;
    @Autowired
    private BuscarNacaoEntidade buscarNacaoEntidade;
    @Autowired
    private DeletarNacao deletarNacao;
    @Autowired
    private BuscarNacaoPorId buscarNacaoPorId;

    public NacaoDTO cadastrarNacao(NacaoDTO dto) {
        return getDto(cadastrarNacao.executar(dto));
    }

    public List<NacaoDTO> listarRankingNacoes() {
        return listarRanking.executar().stream().map(NacaoService::getDto).toList();
    }

    public NacaoDTO retornarNacao(Long id) {
        return NacaoService.getDto(buscarNacaoPorId.executar(id));
    }

    public void deletarNacao(Long id) {
        deletarNacao.executar(id);
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
