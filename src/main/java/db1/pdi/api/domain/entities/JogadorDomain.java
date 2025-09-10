package db1.pdi.api.domain.entities;

import db1.pdi.api.dto.JogadorDTO;
import lombok.Getter;

@Getter
public class JogadorDomain {
    private final Long idJogador;
    private final String nomeJogador;
    private final String emailJogador;
    private Long pontuacaoJogador;
    private final Long idNacao;
    private boolean ativo;

    public JogadorDomain(
            Long idJogador,
            String nomeJogador,
            String emailJogador,
            Long pontuacaoJogador,
            Long idNacao) {

        this.idJogador = idJogador;
        this.nomeJogador = nomeJogador;
        this.emailJogador = emailJogador;
        this.pontuacaoJogador = pontuacaoJogador;
        this.idNacao = idNacao;
        this.ativo = true;
    }

    public void atualizaPontos(Long pontos) {
        if (this.pontuacaoJogador + pontos < 0) {
            this.pontuacaoJogador = 0L;

        } else {
            this.pontuacaoJogador += pontos;
    }
    }

    public void inativar() {
        if (!ativo) {
            throw new IllegalStateException("Jogador já está inativo");
        }
        this.ativo = false;
    }

    public static JogadorDomain fromDTO(JogadorDTO dto){
        return new JogadorDomain(
                dto.idJogador(),
                dto.nomeJogador(),
                dto.emailJogador(),
                dto.pontuacaoJogador(),
                dto.idNacao()
        );
    }

}
