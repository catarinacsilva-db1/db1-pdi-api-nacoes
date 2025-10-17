package db1.pdi.api.nacao.controller.response;


import lombok.Builder;
import java.util.List;

@Builder
public record DetalheNacaoResponse(Long idNacao, String nomeNacao, List jogadores) {
}
