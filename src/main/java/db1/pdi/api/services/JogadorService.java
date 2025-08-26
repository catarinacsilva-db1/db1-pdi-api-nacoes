package db1.pdi.api.services;


import db1.pdi.api.dto.GetJogadorDTO;
import db1.pdi.api.dto.JogadorDTO;
import db1.pdi.api.dto.PontuacaoJogadorDTO;
import db1.pdi.api.entities.entitiesJPA.JogadorEntityJPA;
import db1.pdi.api.repositories.IJogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class JogadorService implements IJogadorService{

    @Autowired
    public IJogadorRepository repository;

    public void cadastrarJogador(JogadorDTO jogadorDTO) {
        repository.save((new JogadorEntityJPA(jogadorDTO)));
    }

    public Page<GetJogadorDTO> listarJogadores(Pageable page) {
        return repository.findAllByAtivoTrue(page).map(GetJogadorDTO::new);
    }

    public GetJogadorDTO retornarJogador(Long id) {
        return repository.findById(id).map(GetJogadorDTO::new) //findbyID ou getReferenceByID?
        .orElseThrow(() -> new RuntimeException("JogadorEntityJPA não encontrado"));
    }
    //exclusão lógica
    public void deletarJogador(Long id) {
        JogadorEntityJPA jogador = repository.getReferenceById(id);
        jogador.inativar();}

    public void atualizarPontuacaoJogador(Long id, PontuacaoJogadorDTO pontos){
        JogadorEntityJPA jogador = repository.getReferenceById(id);
        jogador.setPontuacaoJogador(pontos.pontuacaoJogador());
        repository.save(jogador);
    }

}
