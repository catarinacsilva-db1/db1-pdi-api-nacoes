package db1.pdi.api.nacao.entities;


import db1.pdi.api.jogador.entities.Jogador;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity (name= "NacaoEntity")
@Table (name = "nacao")
@Data
@NoArgsConstructor

public class Nacao {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long idNacao;

    @Column(nullable = false)
    String nomeNacao;

    @OneToMany(mappedBy = "nacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Jogador> jogadores;

    @Transient
    Long pontosNacao;

    public Nacao(Long idNacao, String nomeNacao, List<Jogador> jogadores) {
        this.idNacao = idNacao;
        this.nomeNacao = nomeNacao;
        this.jogadores = jogadores;
    }
}
