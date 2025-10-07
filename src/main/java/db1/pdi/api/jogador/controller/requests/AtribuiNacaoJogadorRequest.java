package db1.pdi.api.jogador.controller.requests;

import jakarta.validation.constraints.Positive;

public record AtribuiNacaoJogadorRequest(@Positive Long idNacao) {
}
