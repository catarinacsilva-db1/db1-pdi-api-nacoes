package db1.pdi.api.entities.entitiesJPA;

import db1.pdi.api.dto.NacaoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity (name= "NacaoEntity")
@Table (name = "nacao")
@Data
@NoArgsConstructor

public class NacaoEntityJPA {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long idNacao;

    @Column(nullable = false)
    String nomeNacao;

    @OneToMany(mappedBy = "nacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<JogadorEntityJPA> jogadores = new java.util.ArrayList<>();

    public NacaoEntityJPA(NacaoDTO nacaoDTO) {
        this.nomeNacao = nacaoDTO.nomeNacao();
    }
}
