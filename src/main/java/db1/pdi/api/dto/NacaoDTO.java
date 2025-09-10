package db1.pdi.api.dto;

import db1.pdi.api.persistence.entitiesJPA.NacaoEntityJPA;
import jakarta.validation.constraints.NotBlank;

public record NacaoDTO(

        @NotBlank
        String nomeNacao)

{
    public NacaoDTO(NacaoEntityJPA nacao) {
        this(nacao.getNomeNacao());
    }
}
