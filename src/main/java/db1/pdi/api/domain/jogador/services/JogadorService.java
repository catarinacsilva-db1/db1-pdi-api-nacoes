package db1.pdi.api.domain.jogador.services;

import db1.pdi.api.domain.jogador.JogadorDTO;
import db1.pdi.api.domain.jogador.entities.JogadorDomain;
import db1.pdi.api.domain.jogador.entities.JogadorDomainFactory;
import db1.pdi.api.domain.jogador.repositories.IJogadorRepositoryDomain;
import db1.pdi.api.domain.nacao.entities.NacaoDTO;
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

    public JogadorDTO cadastrarJogador(JogadorDTO jogadorDTO) {
        JogadorDomain jogador = JogadorDomainFactory.create(jogadorDTO.nomeJogador(), jogadorDTO.emailJogador());
        repository.save(jogador);
        return getDto(jogador);
    }

    public Page<JogadorDTO> listarJogadores(Pageable page) {
        return repository.findAllByAtivoTrue(page).map(JogadorService::getDto);
    }

    public JogadorDTO retornarJogador(Long id) {
        JogadorDomain jogador = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
        return getDto(jogador);
    }
    //exclusão lógica
    public void deletarJogador(Long id) {
        JogadorDomain jogador = repository.getReferenceById(id);
        jogador.inativar();
        repository.save(jogador);
    }

    public JogadorDTO atualizarPontuacaoJogador(Long id, Long pontos){
        JogadorDomain jogador = repository.getReferenceById(id);
        jogador.atualizaPontos(pontos);
        repository.save(jogador);
        return getDto(jogador);
    }

    public JogadorDTO atribuirNacaoAoJogador(Long idJogador, Long idNacao){
        JogadorDomain jogador = repository.getReferenceById(idJogador);
        NacaoDTO nacao = nacaoService.retornarNacao(idNacao);
        jogador.atribuirNacao(nacao);
        repository.save(jogador);
        return getDto(jogador);
    }

    private static JogadorDTO getDto(JogadorDomain jogador) {
        NacaoDTO nacao = new NacaoDTO(jogador.getNacao().idNacao(), jogador.getNacao().nomeNacao());
        return new JogadorDTO(
                jogador.getIdJogador(),
                jogador.getNomeJogador(),
                jogador.getEmailJogador(),
                jogador.getPontuacaoJogador(),
                nacao);
    }
}
