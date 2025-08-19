package db1.pdi.api.dto;

import db1.pdi.api.entities.Jogador;
import jakarta.validation.constraints.PositiveOrZero;

public record PontuacaoJogadorDTO(@PositiveOrZero Long pontuacaoJogador) {

//    public PontuacaoJogadorDTO(Jogador jogador) {
//        this(jogador.getPontuacaoJogador());
//    }

}
