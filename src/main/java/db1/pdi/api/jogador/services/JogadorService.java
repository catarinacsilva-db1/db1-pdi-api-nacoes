package db1.pdi.api.jogador.services;


import db1.pdi.api.jogador.dto.JogadorDTO;
import db1.pdi.api.jogador.entities.Jogador;
import db1.pdi.api.jogador.repositories.IJogadorRepository;
import db1.pdi.api.nacao.dto.NacaoDTO;
import db1.pdi.api.nacao.repository.INacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class JogadorService implements IJogadorService {

    @Autowired
    private IJogadorRepository repository;

    @Autowired
    private INacaoRepository nacaoRepository;

    public JogadorDTO cadastrarJogador(JogadorDTO jogadorDTO) {
        Jogador jogador = new Jogador(null, jogadorDTO.nomeJogador(), jogadorDTO.emailJogador(), 0L, null, true);
        repository.save(jogador);
        return getDto(jogador);
    }

    public Page<JogadorDTO> listarJogadores(Pageable page) {
        return repository.findAllByAtivoTrue(page).map(JogadorService::getDto);
    }

    public JogadorDTO retornarJogador(Long id) {
        Jogador jogador = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
        return getDto(jogador);
    }

    //exclusão lógica
    public void deletarJogador(Long id) {
        Jogador jogador = repository.getReferenceById(id);
        jogador.inativar();
        repository.save(jogador);
    }

    public JogadorDTO atualizarPontuacaoJogador(Long id, Long pontos) {
        Jogador jogador = repository.getReferenceById(id);
        jogador.atualizaPontos(pontos);
        repository.save(jogador);
        return getDto(jogador);
    }

    public JogadorDTO atribuirNacaoAoJogador(Long idJogador, Long idNacao) {
        Jogador jogador = repository.getReferenceById(idJogador);
        jogador.atribuirNacao(nacaoRepository.getReferenceById(idNacao));
        repository.save(jogador);
        return getDto(jogador);
    }

    private static JogadorDTO getDto(Jogador jogador) {
        NacaoDTO nacao = jogador.getNacao() != null
                ? new NacaoDTO(jogador.getNacao().getIdNacao(), jogador.getNacao().getNomeNacao())
                : new NacaoDTO(null, "Sem nação");
        return new JogadorDTO(
                jogador.getIdJogador(),
                jogador.getNomeJogador(),
                jogador.getEmailJogador(),
                jogador.getPontuacaoJogador(),
                nacao);
    }
}
