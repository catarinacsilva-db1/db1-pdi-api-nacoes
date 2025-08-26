package db1.pdi.api.services;

import db1.pdi.api.dto.GetJogadorDTO;
import db1.pdi.api.dto.JogadorDTO;
import db1.pdi.api.dto.PontuacaoJogadorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IJogadorService {
    void cadastrarJogador(JogadorDTO jogadorDTO);

    Page<GetJogadorDTO> listarJogadores(Pageable page);

    GetJogadorDTO retornarJogador(Long id);

    void deletarJogador(Long id);

    void atualizarPontuacaoJogador(Long id, PontuacaoJogadorDTO pontos);
}
