package db1.pdi.api.dto;

import db1.pdi.api.entities.entitiesJPA.JogadorEntityJPA;

public record GetJogadorDTO(Long id, String nomeJogador, Long pontuacaoJogador) {

    public GetJogadorDTO(JogadorEntityJPA jogador) {
        this(
                jogador.getIdJogador(),
                jogador.getNomeJogador(),
                jogador.getPontuacaoJogador());
    }
}
