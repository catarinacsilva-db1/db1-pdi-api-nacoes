package db1.pdi.api.dto;

import db1.pdi.api.entities.entitiesJPA.NacaoEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record NacaoDTO(

        @NotBlank
        String nomeNacao,

{
    public NacaoDTO(NacaoEntity nacao) {
        this(nacao.getNomeNacao(), nacao.getPontuacaoNacao());
    }
}
