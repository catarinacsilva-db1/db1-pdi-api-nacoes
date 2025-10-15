package db1.pdi.api.nacao.controller.response;

import lombok.Builder;

@Builder
public record NacaoFromJogadorResponse (Long idNacao, String nomeNacao) {
}
