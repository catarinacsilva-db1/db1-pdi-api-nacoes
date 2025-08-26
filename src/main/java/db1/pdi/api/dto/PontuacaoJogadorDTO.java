package db1.pdi.api.dto;

import jakarta.validation.constraints.PositiveOrZero;

public record PontuacaoJogadorDTO(Long idJogador, @PositiveOrZero Long pontuacaoJogador) {
}
