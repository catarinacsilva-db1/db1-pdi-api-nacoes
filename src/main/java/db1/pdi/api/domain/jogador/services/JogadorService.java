package db1.pdi.api.domain.jogador.services;



import db1.pdi.api.domain.jogador.entities.JogadorDomain;
import db1.pdi.api.domain.jogador.repositories.IJogadorRepositoryDomain;
import db1.pdi.api.domain.nacao.entities.NacaoDomain;
import db1.pdi.api.domain.nacao.services.INacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class JogadorService implements IJogadorService {

    @Autowired
    private IJogadorRepositoryDomain repository;

    @Autowired
    private INacaoService nacaoService;

    public JogadorDomain cadastrarJogador(JogadorDomain jogador) {
        return repository.save(jogador);
    }

    public Page<JogadorDomain> listarJogadores(Pageable page) {
        return repository.findAllByAtivoTrue(page);
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

    public JogadorDomain atribuirNacaoAoJogador(Long idJogador, Long idNacao){
        JogadorDomain jogador = repository.getReferenceById(idJogador);
        NacaoDomain nacao = nacaoService.retornarNacao(idNacao);
        jogador.atribuirNacao(nacao);
        return repository.save(jogador);
    }

}
