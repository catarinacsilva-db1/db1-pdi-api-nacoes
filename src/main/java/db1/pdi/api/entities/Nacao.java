package db1.pdi.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity (name= "Nacao")
@Table (name = "Nacao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Nacao {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long idNacao;
    String nomeNacao;
    Long pontuacaoNacao;
}
