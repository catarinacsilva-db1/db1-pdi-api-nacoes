package db1.pdi.api.controller;

import db1.pdi.api.controller.requests.CreateJogadorRequest;
import db1.pdi.api.dto.AtualizaPontosJogadorRequest;
import db1.pdi.api.dto.JogadorDTO;
import db1.pdi.api.dto.JogadorDTOResponse;
import db1.pdi.api.services.IJogadorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/jogadores")
public class JogadorController {

 
    @Autowired
    IJogadorService service;

    @PostMapping
    @Transactional
    public ResponseEntity<JogadorDTO> postJogador(@RequestBody @Valid CreateJogadorRequest request) {
        JogadorDTO jogadorDTO = new JogadorDTO(request.nomeJogador(), request.emailJogador(), 0L);
        service.cadastrarJogador(jogadorDTO);
        //TODO: retornar DTO com ID criado
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorDTO);
    }

    @GetMapping
    public ResponseEntity<Page<JogadorDTOResponse> getListaJogadores(Pageable page) {
        Page<JogadorDTOResponse> pagina = service.listarJogadores(page);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogadorDTOResponse> getJogador(@PathVariable Long id) {
        return service.retornarJogador(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteJogador(@PathVariable Long id) {
        service.deletarJogador(id);
    return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity patchPontuacaoJogador(@PathVariable Long id, @RequestBody @Valid AtualizaPontosJogadorRequest pontos){
        var jogadorAtualizado = service.atualizarPontuacaoJogador(id, pontos);
        return ResponseEntity.ok(
                new JogadorDTOResponse(
                        jogadorAtualizado.getIdJogador(),
                        jogadorAtualizado.getNomeJogador(),
                        jogadorAtualizado.getPontuacaoJogador()));
    }
    //put para atualizar o Nome e email de jogador?
}


