package db1.pdi.api.domain.services;


import db1.pdi.api.dto.JogadorDTO;
import db1.pdi.api.domain.entities.JogadorDomain;
import db1.pdi.api.persistence.entitiesJPA.JogadorEntityJPA;
import db1.pdi.api.repositories.IJogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class JogadorService implements IJogadorService{

    @Autowired
    public IJogadorRepository repository;

    public JogadorDomain cadastrarJogador(JogadorDTO jogadorDTO) {
        JogadorDomain jogador = JogadorDomain.fromDTO(jogadorDTO);
        return repository.save(jogador);
    }

    public Page<JogadorDomain> listarJogadores(Pageable page) {
        return repository.findAllByAtivoTrue(page).map(JogadorDomain::new);
    }

    public JogadorDomain retornarJogador(Long id) {
        return repository.findById(id).map(JogadorDomain::new)
        .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
    }

    //exclusão lógica
    public void deletarJogador(Long id) {
        JogadorDomain jogadorJPA = repository.getReferenceById(id);
        jogador.inativar();}

    public JogadorDomain atualizarPontuacaoJogador(Long id, Long pontos){
        JogadorEntityJPA jogador = repository.getReferenceById(id);
        jogador.setPontuacaoJogador(pontos);
        return repository.save(jogador);
    }
}
