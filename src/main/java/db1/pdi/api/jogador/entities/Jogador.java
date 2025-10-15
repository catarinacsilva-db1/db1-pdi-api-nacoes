package db1.pdi.api.jogador.entities;

import db1.pdi.api.nacao.entities.Nacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity(name = "jogador")
@Table(name = "jogador")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Jogador {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJogador;

    @Column(nullable = false)
    private String nomeJogador;

    @Column(nullable = false, unique = true)
    private String emailJogador;

    @PositiveOrZero
    private Long pontuacaoJogador;

    @ManyToOne
    @JoinColumn(name = "id_nacao")
    private Nacao nacao;

    public Jogador(String nomeJogador, String emailJogador) {
        this.idJogador = null;
        this.nomeJogador = nomeJogador;
        this.emailJogador = emailJogador;
        this.pontuacaoJogador = 0L;
        this.nacao = null;
    }
    public void atribuirNacao(Nacao nacao) {
        if (this.nacao != null) {
            throw new IllegalStateException("Jogador já pertence a uma nação");
        }
        this.nacao = nacao;
    }

    public void atualizaPontos(Long pontos) {
        if (this.pontuacaoJogador + pontos < 0) {
            this.pontuacaoJogador = 0L;

        } else {
            this.pontuacaoJogador += pontos;
        }
    }
}
