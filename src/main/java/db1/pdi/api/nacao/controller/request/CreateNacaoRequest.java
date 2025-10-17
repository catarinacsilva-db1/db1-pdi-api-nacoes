package db1.pdi.api.nacao.controller.request;

import jakarta.validation.constraints.NotBlank;

public record CreateNacaoRequest(
        @NotBlank
        String nomeNacao
) {
}
