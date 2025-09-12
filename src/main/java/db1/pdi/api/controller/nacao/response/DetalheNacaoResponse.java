package db1.pdi.api.controller.nacao.response;


import java.util.List;

public record DetalheNacaoResponse(Long idNacao, String nomeNacao, List jogadores) {
}
