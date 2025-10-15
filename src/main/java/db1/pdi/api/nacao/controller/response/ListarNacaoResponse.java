package db1.pdi.api.nacao.controller.response;

import lombok.Builder;

@Builder
public record ListarNacaoResponse(Long idNacao, String nomeNacao, Long pontosNacao) {
}
