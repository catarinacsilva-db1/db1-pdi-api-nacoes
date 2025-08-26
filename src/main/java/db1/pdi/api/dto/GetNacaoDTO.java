package db1.pdi.api.dto;

import db1.pdi.api.entities.entitiesJPA.NacaoEntity;


public record GetNacaoDTO(

        Long id,
        String nomeNacao,
        Long pontuacaoNacao) //soma da pontuação de todos os jogadores
{
    public GetNacaoDTO(NacaoEntity nacao) {
        this(
                nacao.getIdNacao(),
                nacao.getNomeNacao(),
                nacao.getPontuacaoNacao());
    }
}
