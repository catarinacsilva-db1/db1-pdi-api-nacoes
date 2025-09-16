package db1.pdi.api.domain.jogador.entities;

import db1.pdi.api.domain.nacao.entities.NacaoDTO;
import lombok.Getter;

@Getter
public class JogadorDomain {
    private final Long idJogador;
    private final String nomeJogador;
    private final String emailJogador;
    private Long pontuacaoJogador;
    private NacaoDTO nacao;
    private boolean ativo;

    public JogadorDomain(Long idJogador, String nomeJogador, String emailJogador, Long pontuacaoJogador, NacaoDTO nacao) {
        this.idJogador = idJogador;
        this.nomeJogador = nomeJogador;
        this.emailJogador = emailJogador;
        this.pontuacaoJogador = pontuacaoJogador;
        this.nacao = nacao;
        this.ativo = true;
    }


    public void atribuirNacao(NacaoDTO nacao) {
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

    public void inativar() {
        if (!ativo) {
            throw new IllegalStateException("Jogador já está inativo");
        }
        this.ativo = false;
    }
}
