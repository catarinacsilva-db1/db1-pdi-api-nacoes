package db1.pdi.api.jogador.services.usecases;

import db1.pdi.api.infra.exceptions.EntidadeNaoEncontradaException;
import db1.pdi.api.jogador.entities.Jogador;

import db1.pdi.api.nacao.services.usecases.BuscarNacaoEntidade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import({BuscarJogadorPorId.class, BuscarNacaoEntidade.class, AtribuirNacaoAoJogador.class})
class AtribuirNacaoAoJogadorTest {

    @Autowired
    private TestEntityManager em;
    @Autowired
    private BuscarJogadorPorId buscarJogadorPorId;
    @Autowired
    private BuscarNacaoEntidade buscarNacaoEntidade;
    @Autowired
    private AtribuirNacaoAoJogador atribuirNacaoAoJogador;

    @Test
    @DisplayName("Deve lançar exceção ao atribuir nação inexistente ao jogador")

    void atribuirNacaoInexistenteAoJogador() {
        Jogador jogador = new Jogador(null, "Jogador1", "teste@email.com", 0L, null);
        Jogador jogadorSalvo = em.persistFlushFind(jogador);
        Long nacaoIdInexistente = 9999999L;

        assertThrows(EntidadeNaoEncontradaException.class, () -> {
            atribuirNacaoAoJogador.executar(jogadorSalvo.getIdJogador(), nacaoIdInexistente);
        });
}
}