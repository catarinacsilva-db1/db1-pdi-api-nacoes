package db1.pdi.api.entities.domain;


public record Jogador(
        Long idJogador,
        String nomeJogador,
        String emailJogador,
        Long pontuacaoJogador,
        Long idNacao,
        Boolean ativo) {
}
