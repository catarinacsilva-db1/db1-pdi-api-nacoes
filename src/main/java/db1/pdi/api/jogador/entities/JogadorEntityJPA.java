package db1.pdi.api.jogador.entities;

import db1.pdi.api.nacao.entities.NacaoEntityJPA;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity(name = "jogador")
@Table(name = "jogador")
@Data
@NoArgsConstructor
public class JogadorEntityJPA {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJogador;

    @Column(nullable = false)
    private String nomeJogador;

    @Column(nullable = false, unique = true)
    private String emailJogador;

    @PositiveOrZero @Column(nullable = false)
    private Long pontuacaoJogador;

    @ManyToOne
    @JoinColumn(name = "id_nacao")
    private NacaoEntityJPA nacao;

    private Boolean ativo;

    public JogadorEntityJPA(Long idJogador, String nomeJogador, String emailJogador, Long pontuacaoJogador, NacaoEntityJPA nacao, Boolean ativo) {
        this.idJogador = idJogador;
        this.nomeJogador = nomeJogador;
        this.emailJogador = emailJogador;
        this.pontuacaoJogador = pontuacaoJogador;
        this.nacao = nacao;
        this.ativo = ativo;
    }
}
