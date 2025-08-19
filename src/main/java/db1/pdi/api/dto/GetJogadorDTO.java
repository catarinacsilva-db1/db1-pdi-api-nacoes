package db1.pdi.api.dto;

import db1.pdi.api.entities.Jogador;

public record GetJogadorDTO(Long id, String nomeJogador, Long pontuacaoJogador) {

    public GetJogadorDTO(Jogador jogador) {
        this(jogador.getIdJogador(), jogador.getNomeJogador(), jogador.getPontuacaoJogador());
    }
}
