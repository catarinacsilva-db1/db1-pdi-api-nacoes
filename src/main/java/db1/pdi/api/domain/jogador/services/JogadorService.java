package db1.pdi.api.domain.jogador.services;


import db1.pdi.api.dto.JogadorDTO;
import db1.pdi.api.domain.jogador.entities.JogadorDomain;
import db1.pdi.api.domain.jogador.repositories.IJogadorRepositoryDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class JogadorService implements IJogadorService {

    @Autowired
    public IJogadorRepositoryDomain repository;

    public JogadorDomain cadastrarJogador(JogadorDomain jogador) {
        return repository.save(jogador);
    }

    public Page<JogadorDomain> listarJogadores(Pageable page) {
        return repository.findAllByAtivoTrue(page).map(JogadorDomain::new);
    }

    public JogadorDomain retornarJogador(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
    }

    //exclusão lógica
    public void deletarJogador(Long id) {
        JogadorDomain jogador = repository.getReferenceById(id);
        jogador.inativar();
        repository.save(jogador);
    }

    public JogadorDomain atualizarPontuacaoJogador(Long id, Long pontos){
        JogadorDomain jogador = repository.getReferenceById(id);
        jogador.atualizaPontos(pontos);
        return repository.save(jogador);
    }
}
