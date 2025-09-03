package db1.pdi.api.dto;


import db1.pdi.api.entities.entitiesJPA.NacaoEntityJPA;


public record GetNacaoDTO(

        Long id,
        String nomeNacao) //soma da pontuação de todos os jogadores
{
    public GetNacaoDTO(NacaoEntityJPA nacao) {
        this(
                nacao.getIdNacao(),
                nacao.getNomeNacao());
    }
}
