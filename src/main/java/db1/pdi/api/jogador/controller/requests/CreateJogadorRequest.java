package db1.pdi.api.jogador.controller.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateJogadorRequest(
        @NotBlank
        String nomeJogador,

        @NotBlank
        @Email
        String emailJogador
) {
}
