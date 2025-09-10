package db1.pdi.api.domain.services;

import db1.pdi.api.dto.JogadorDTO;
import db1.pdi.api.domain.entities.JogadorDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IJogadorService {

    //TODO: retornar JogadorDomain com ID
    JogadorDomain cadastrarJogador(JogadorDTO jogadorDTO);

    Page<JogadorDomain> listarJogadores(Pageable page);

    JogadorDomain retornarJogador(Long id);

    void deletarJogador(Long id);

    JogadorDomain atualizarPontuacaoJogador(Long id, Long pontos);
}
