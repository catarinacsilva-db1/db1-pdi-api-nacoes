package db1.pdi.api.nacao.controller.response;


import java.util.List;

public record DetalheNacaoResponse(Long idNacao, String nomeNacao, List jogadores) {
}
