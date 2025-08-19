package db1.pdi.api.entities;

import db1.pdi.api.dto.JogadorDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "jogador")
@Table(name = "jogador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Jogador {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJogador;

    @Column(nullable = false)
    private String nomeJogador;

    @Column(nullable = false, unique = true)
    private String emailJogador;

    //colocar notação para n ser menor que zero
    private Long pontuacaoJogador;

    private Boolean ativo = true;

    public Jogador(JogadorDTO jogadorDTO){
        this.nomeJogador = jogadorDTO.nomeJogador();
        this.emailJogador = jogadorDTO.emailJogador();
        this.pontuacaoJogador = jogadorDTO.pontuacaoJogador();
    }

    public void inativar() {
        this.ativo = false;
    }

    //notação para indicar que o jogador pertence a uma nação
    //private Long idNacao;

}
