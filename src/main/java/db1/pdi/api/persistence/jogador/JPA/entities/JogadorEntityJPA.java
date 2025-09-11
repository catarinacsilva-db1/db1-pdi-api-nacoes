package db1.pdi.api.persistence.jogador.JPA.entities;

import db1.pdi.api.persistence.nacao.JPA.entities.NacaoEntityJPA;
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

    @PositiveOrZero

    private Long pontuacaoJogador;

    @ManyToOne
    private NacaoEntityJPA nacao;

    private Boolean ativo = true;

   public Long getNacaoId(){
       if (nacao != null) {
           return nacao.getIdNacao();
       } else {
           throw new IllegalArgumentException("Não há Nação associada ao jogador");
       }
   }
}
