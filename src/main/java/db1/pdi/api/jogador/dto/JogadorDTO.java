package db1.pdi.api.jogador.dto;


import db1.pdi.api.nacao.dto.NacaoDTO;

public record JogadorDTO(
        Long idJogador,
        String nomeJogador,
        String emailJogador,
        Long pontuacaoJogador,
        NacaoDTO nacao) {

    public JogadorDTO(Builder builder) {
        this(builder.idJogador, builder.nomeJogador, builder.emailJogador, builder.pontuacaoJogador, builder.nacao);
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private Long idJogador;
        private String nomeJogador;
        private String emailJogador;
        private Long pontuacaoJogador;
        private NacaoDTO nacao;

        public Builder idJogador(Long idJogador) {
            this.idJogador = idJogador;
            return this;
        }

        public Builder nomeJogador(String nomeJogador) {
            this.nomeJogador = nomeJogador;
            return this;
        }

        public Builder emailJogador(String emailJogador) {
            this.emailJogador = emailJogador;
            return this;
        }

        public Builder pontuacaoJogador(Long pontuacaoJogador) {
            this.pontuacaoJogador = pontuacaoJogador;
            return this;
        }

        public Builder nacao(NacaoDTO nacao) {
            this.nacao = nacao;
            return this;
        }

        public JogadorDTO build() {
            return new JogadorDTO(this);
        }
    }
}
