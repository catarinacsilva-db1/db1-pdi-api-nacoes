package db1.pdi.api.jogador.services;


import db1.pdi.api.jogador.dto.JogadorDTO;
import db1.pdi.api.jogador.entities.Jogador;
import db1.pdi.api.jogador.repositories.IJogadorRepository;
import db1.pdi.api.jogador.services.usecases.*;
import db1.pdi.api.nacao.dto.NacaoDTO;
import db1.pdi.api.nacao.services.INacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class JogadorService implements IJogadorService {

    @Autowired
    private IJogadorRepository repository;

    @Autowired
    private INacaoService nacaoService;

    @Autowired
    private CadastrarJogadorUseCase cadastrarJogadorCase;
    private ListarJogadoresUseCase listarJogadoresUseCase;
    private BuscarJogadorPorIdUseCase buscarJogadorPorIdUseCase;
    private AtualizarPontuacaoJogadorUseCase atualizarPontuacaoJogadorUseCase;
    private DeletarJogadorUseCase deletarJogadorUseCase;
    private AtribuirNacaoAoJogadorUseCase atribuirNacaoAoJogadorUseCase;

    public JogadorDTO cadastrarJogador(JogadorDTO jogadorDTO) {
        return getDto(cadastrarJogadorCase.executar(jogadorDTO));
    }

    public Page<JogadorDTO> listarJogadores(Pageable page) {
        return listarJogadoresUseCase.executar(page).map(JogadorService::getDto);
    }

    public JogadorDTO retornarJogador(Long id) {
        return getDto(buscarJogadorPorIdUseCase.executar(id));
    }

    public void deletarJogador(Long id) {
        deletarJogadorUseCase.executar(id);
    }

    public JogadorDTO atualizarPontuacaoJogador(Long id, Long pontos) {
        return getDto(atualizarPontuacaoJogadorUseCase.executar(id, pontos));
    }

    public JogadorDTO atribuirNacaoAoJogador(Long idJogador, Long idNacao) {
        return getDto(atribuirNacaoAoJogadorUseCase.executar(idJogador, idNacao));
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
