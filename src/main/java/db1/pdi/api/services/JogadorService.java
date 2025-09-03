package db1.pdi.api.services;


import db1.pdi.api.dto.JogadorDTOResponse;
import db1.pdi.api.dto.JogadorDTO;
import db1.pdi.api.dto.PontosJogadorDTO;
import db1.pdi.api.entities.entitiesJPA.JogadorEntityJPA;
import db1.pdi.api.repositories.IJogadorRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class JogadorService implements IJogadorService{

    @Autowired
    public IJogadorRepositoryJPA repository;

    public void cadastrarJogador(JogadorDTO jogadorDTO) {
        repository.save((new JogadorEntityJPA(jogadorDTO)));
    }

    public Page<JogadorDTOResponse> listarJogadores(Pageable page) {
        return repository.findAllByAtivoTrue(page).map(JogadorDTOResponse::new);
    }

    public JogadorDTOResponse retornarJogador(Long id) {
        return repository.findById(id).map(JogadorDTOResponse::new) //findbyID ou getReferenceByID?
        .orElseThrow(() -> new RuntimeException("JogadorEntityJPA não encontrado"));
    }
    //exclusão lógica
    public void deletarJogador(Long id) {
        JogadorEntityJPA jogador = repository.getReferenceById(id);
        //TODO: retirar esse método de JPA
        jogador.inativar();}

    public JogadorEntityJPA atualizarPontuacaoJogador(Long id, PontosJogadorDTO pontos){
        JogadorEntityJPA jogador = repository.getReferenceById(id);
        jogador.setPontuacaoJogador(pontos.pontosJogador());
        return repository.save(jogador);
    }

}
