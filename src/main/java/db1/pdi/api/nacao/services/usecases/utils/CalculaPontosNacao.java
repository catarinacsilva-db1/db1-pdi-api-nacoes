package db1.pdi.api.nacao.services.usecases.utils;

import db1.pdi.api.nacao.entities.Nacao;
import org.springframework.stereotype.Component;

@Component
public class CalculaPontosNacao {

    public static Nacao executar(Nacao nacao) {
        long pontos = nacao.getJogadores() != null ?
                nacao.getJogadores().stream()
                        .mapToLong(j -> j.getPontuacaoJogador())
                        .sum() : 0;

        nacao.setPontosNacao(pontos);
        return nacao;
    }
}
