package db1.pdi.api.services;

import db1.pdi.api.dto.JogadorDTOResponse;
import db1.pdi.api.dto.JogadorDTO;
import db1.pdi.api.dto.PontosJogadorDTO;
import db1.pdi.api.entities.entitiesJPA.JogadorEntityJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IJogadorService {

    //TODO: retornar Jogador com ID
    void cadastrarJogador(JogadorDTO jogadorDTO);

    Page<JogadorDTOResponse> listarJogadores(Pageable page);

    JogadorDTOResponse retornarJogador(Long id);

    void deletarJogador(Long id);

    JogadorEntityJPA atualizarPontuacaoJogador(Long id, PontosJogadorDTO pontos);
}
