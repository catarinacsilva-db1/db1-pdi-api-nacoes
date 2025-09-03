package db1.pdi.api.dto;

import db1.pdi.api.entities.entitiesJPA.NacaoEntityJPA;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record NacaoDTO(

        @NotBlank
        String nomeNacao)

{
    public NacaoDTO(NacaoEntityJPA nacao) {
        this(nacao.getNomeNacao());
    }
}
