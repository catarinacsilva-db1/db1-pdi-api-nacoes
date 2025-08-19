package db1.pdi.api.controller;

import db1.pdi.api.dto.JogadorDTO;
import db1.pdi.api.dto.GetJogadorDTO;
import db1.pdi.api.dto.PontuacaoJogadorDTO;
import db1.pdi.api.entities.Jogador;
import db1.pdi.api.repositories.IJogadorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    //Anotação ou construtor para injeção de dependência?
    @Autowired
    public IJogadorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarJogador(@RequestBody @Valid JogadorDTO jogadorDTO) {
        repository.save((new Jogador(jogadorDTO)));
    }

    @GetMapping
    public Page<GetJogadorDTO> listarJogadores(Pageable page) {
        return repository.findAllByAtivoTrue(page).map(GetJogadorDTO::new);
    }

    //findbyID ou getReferenceByID?
    @GetMapping("/{id}")
    public GetJogadorDTO retornarJogador(@PathVariable Long id) {
        return repository.findById(id).map(GetJogadorDTO::new)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
    }

    @DeleteMapping("/{id}")
    @Transactional
    //exclusão lógica
    public void deletarJogador(@PathVariable Long id) {
        Jogador jogador = repository.getReferenceById(id);
        jogador.inativar();}

    @PatchMapping("/{id}")
    @Transactional
    public void atualizarPontuacaoJogador(@PathVariable Long id, @RequestBody @Valid PontuacaoJogadorDTO pontos){
        Jogador jogador = repository.getReferenceById(id);
        jogador.setPontuacaoJogador(pontos.pontuacaoJogador());
        repository.save(jogador);
    }

    //put para atualizar o Nome e email de jogador?

}


