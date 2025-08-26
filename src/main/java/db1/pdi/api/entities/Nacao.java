package db1.pdi.api.entities;

import java.util.List;

public record Nacao(Long idNacao, String nomeNacao, List<Jogador> jogadores) {
}
