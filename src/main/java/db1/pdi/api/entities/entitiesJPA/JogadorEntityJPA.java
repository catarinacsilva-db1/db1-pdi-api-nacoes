package db1.pdi.api.entities.entitiesJPA;

import db1.pdi.api.dto.JogadorDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity(name = "jogador")
@Table(name = "jogador")
@Data
@NoArgsConstructor
public class JogadorEntityJPA {

    public Long id;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJogador;

    @Column(name = "nome_jogador", nullable = false)
    private String nomeJogador;

    @Column(name = "email_jogador", nullable = false, unique = true)
    private String emailJogador;

    @PositiveOrZero
    @Column(name = "pontuacao_jogador")
    private Long pontuacaoJogador;

    @ManyToOne
    @JoinColumn(name = "id_nacao")
    private NacaoEntityJPA nacao;

    private Boolean ativo = true;

    //TODO alterar para receber propriedade de entity
    public JogadorEntityJPA(JogadorDTO jogadorDTO){
        this.nomeJogador = jogadorDTO.nomeJogador();
        this.emailJogador = jogadorDTO.emailJogador();
        this.pontuacaoJogador = jogadorDTO.pontuacaoJogador();
    }

    public void inativar() {
        this.ativo = false;
    }

}
