package db1.pdi.api.dto;

import jakarta.validation.constraints.PositiveOrZero;

public record AtualizaPontosJogadorRequest(Long idJogador, @PositiveOrZero Long pontosJogador) {
}
