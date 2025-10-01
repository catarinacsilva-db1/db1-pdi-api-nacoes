package db1.pdi.api.jogador.dto;


import db1.pdi.api.nacao.dto.NacaoDTO;

public record JogadorDTO(Long idJogador, String nomeJogador, String emailJogador, Long pontuacaoJogador, NacaoDTO nacao) {

    //construtor para criação de jogador sem id, pontuação e nação
     public JogadorDTO (String nomeJogador, String emailJogador) {
        this(null, nomeJogador, emailJogador, 0L, null);
    }
    //construtor para criação de listas jogadores sem email e nação
    public JogadorDTO(Long idJogador, String nomeJogador, Long pontuacaoJogador) {
         this(idJogador, nomeJogador, null, pontuacaoJogador, null);
    }
}
