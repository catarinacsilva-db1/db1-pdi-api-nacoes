package db1.pdi.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;


public record JogadorDTO(

        Long idJogador,

        @NotBlank
        String nomeJogador,

        @NotBlank
        @Email
        String emailJogador,

        @PositiveOrZero
        Long pontuacaoJogador,

        Long idNacao
) {

}
