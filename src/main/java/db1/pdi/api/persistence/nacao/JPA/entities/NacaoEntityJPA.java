package db1.pdi.api.persistence.nacao.JPA.entities;


import db1.pdi.api.persistence.jogador.JPA.entities.JogadorEntityJPA;
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
    List<JogadorEntityJPA> jogadores;

    public NacaoEntityJPA(Long idNacao, String nomeNacao, List<JogadorEntityJPA> jogadores) {
        this.idNacao = idNacao;
        this.nomeNacao = nomeNacao;
        this.jogadores = jogadores;
    }
}
