package db1.pdi.api.domain.jogador.services;

import db1.pdi.api.domain.jogador.entities.JogadorDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IJogadorService {

    JogadorDomain cadastrarJogador(JogadorDomain jogador);

    Page<JogadorDomain> listarJogadores(Pageable page);

    JogadorDomain retornarJogador(Long id);

    void deletarJogador(Long id);

    JogadorDomain atualizarPontuacaoJogador(Long id, Long pontos);

    JogadorDomain atribuirNacaoAoJogador(Long idJogador, Long idNacao);
}
