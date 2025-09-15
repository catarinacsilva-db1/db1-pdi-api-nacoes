package db1.pdi.api.domain.jogador.entities;

import jdk.jfr.Category;
import org.springframework.stereotype.Component;

@Component
public class JogadorDomainFactory {
    public static JogadorDomain create(String nomeJogador, String emailJogador) {
        return new JogadorDomain(
                null,
                nomeJogador,
                emailJogador,
                0L,
                null);
    }

    public static JogadorDomain toListJogadores(Long idJogador, String nomeJogador, Long pontuacaoJogador) {
        return new JogadorDomain(
                idJogador,
                nomeJogador,
                null,
                pontuacaoJogador,
                null);
    }
}
