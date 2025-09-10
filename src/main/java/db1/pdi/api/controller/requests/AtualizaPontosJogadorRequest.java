package db1.pdi.api.controller.requests;

import jakarta.validation.constraints.PositiveOrZero;

public record AtualizaPontosJogadorRequest(Long idJogador, @PositiveOrZero Long pontosJogador) {
}
