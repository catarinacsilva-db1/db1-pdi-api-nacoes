package db1.pdi.api.jogador.services;

import db1.pdi.api.jogador.dto.JogadorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IJogadorService {

    JogadorDTO cadastrarJogador(JogadorDTO jogador);

    Page<JogadorDTO> listarJogadores(Pageable page);

    JogadorDTO retornarJogador(Long id);

    void deletarJogador(Long id);

    JogadorDTO atualizarPontuacaoJogador(Long id, Long pontos);

    JogadorDTO atribuirNacaoAoJogador(Long idJogador, Long idNacao);
}
