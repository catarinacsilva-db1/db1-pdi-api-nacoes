package db1.pdi.api.controller.response;

import db1.pdi.api.persistence.entitiesJPA.JogadorEntityJPA;

public record DetalheJogadorResponse(Long idJogador, String nomeJogador, Long pontuacaoJogador) {

    //temporario ate arrumar dependencia
    public DetalheJogadorResponse(JogadorEntityJPA jogador){
        this(jogador.getIdJogador(), jogador.getNomeJogador(), jogador.getPontuacaoJogador());
    }
}
