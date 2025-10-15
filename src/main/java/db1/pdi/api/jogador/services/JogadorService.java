package db1.pdi.api.jogador.services;


import db1.pdi.api.jogador.dto.JogadorDTO;
import db1.pdi.api.jogador.entities.Jogador;
import db1.pdi.api.jogador.services.usecases.*;
import db1.pdi.api.nacao.dto.NacaoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class JogadorService implements IJogadorService {

    @Autowired
    private CadastrarJogador cadastrarJogador;
    @Autowired
    private ListarJogadores listarJogadores;
    @Autowired
    private BuscarJogadorPorId buscarJogadorPorId;
    @Autowired
    private AtualizarPontuacaoJogador atualizarPontuacaoJogador;
    @Autowired
    private DeletarJogador deletarJogador;
    @Autowired
    private AtribuirNacaoAoJogador atribuirNacaoAoJogador;

    public JogadorDTO cadastrarJogador(JogadorDTO jogadorDTO) {
        return getDto(cadastrarJogador.executar(jogadorDTO));
    }

    public Page<JogadorDTO> listarJogadores(Pageable page) {
        return listarJogadores.executar(page).map(JogadorService::getDto);
    }

    public JogadorDTO retornarJogador(Long id) {
        return getDto(buscarJogadorPorId.executar(id));
    }

    public void deletarJogador(Long id) {
        deletarJogador.executar(id);
    }

    public JogadorDTO atualizarPontuacaoJogador(Long id, Long pontos) {
        return getDto(atualizarPontuacaoJogador.executar(id, pontos));
    }

    public JogadorDTO atribuirNacaoAoJogador(Long idJogador, Long idNacao) {
        return getDto(atribuirNacaoAoJogador.executar(idJogador, idNacao));
    }



    private static JogadorDTO getDto(Jogador jogador) {
        NacaoDTO nacao = jogador.getNacao() != null
                ? NacaoDTO.builder()
                .idNacao(jogador.getNacao().getIdNacao())
                .nomeNacao(jogador.getNacao().getNomeNacao())
                .build()

                : NacaoDTO.builder().nomeNacao("Sem nação")
                .build();

        return JogadorDTO.builder()
                .idJogador(jogador.getIdJogador())
                .emailJogador(jogador.getEmailJogador())
                .nomeJogador(jogador.getNomeJogador())
                .pontuacaoJogador(jogador.getPontuacaoJogador())
                .nacao(nacao)
                .build();
    }
}
