package db1.pdi.api.entities.entitiesJPA;

import db1.pdi.api.dto.JogadorDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity(name = "jogador")
@Table(name = "jogador")
@Data
public class JogadorEntityJPA {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJogador;

    @Column(nullable = false)
    private String nomeJogador;

    @Column(nullable = false, unique = true)
    private String emailJogador;

    @PositiveOrZero
    private Long pontuacaoJogador;

    @ManyToOne
    @JoinColumn(name = "idNacao")
    private NacaoEntityJPA nacao;

    private Boolean ativo = true;

    public JogadorEntityJPA(JogadorDTO jogadorDTO){
        this.nomeJogador = jogadorDTO.nomeJogador();
        this.emailJogador = jogadorDTO.emailJogador();
        this.pontuacaoJogador = jogadorDTO.pontuacaoJogador();
    }

    public void inativar() {
        this.ativo = false;
    }


}
