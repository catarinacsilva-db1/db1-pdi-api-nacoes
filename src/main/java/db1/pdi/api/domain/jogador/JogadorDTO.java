package db1.pdi.api.domain.jogador;


import db1.pdi.api.domain.nacao.entities.NacaoDTO;

public record JogadorDTO(Long idJogador, String nomeJogador, String emailJogador, Long pontuacaoJogador, NacaoDTO nacao) {

    //construtor para criação de jogador sem id, pontuação e nação
     public JogadorDTO (String nomeJogador, String emailJogador) {
        this(null, nomeJogador, emailJogador, 0L, null);
    }
}
