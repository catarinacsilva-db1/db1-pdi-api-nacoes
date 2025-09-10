package db1.pdi.api.controller;

import db1.pdi.api.controller.requests.CreateJogadorRequest;
import db1.pdi.api.controller.requests.AtualizaPontosJogadorRequest;
import db1.pdi.api.dto.JogadorDTO;
import db1.pdi.api.controller.response.DetalheJogadorResponse;
import db1.pdi.api.domain.services.IJogadorService;
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
    public ResponseEntity<DetalheJogadorResponse> postJogador(@RequestBody @Valid CreateJogadorRequest request) {
        JogadorDTO jogadorDTO = new JogadorDTO(0L, request.nomeJogador(), request.emailJogador(), 0L);
        var jogadorCriado = service.cadastrarJogador(jogadorDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new DetalheJogadorResponse(
                        jogadorCriado.getIdJogador(),
                        jogadorCriado.getNomeJogador(),
                        jogadorCriado.getPontuacaoJogador()));
    }

    @GetMapping
    public ResponseEntity<Page<DetalheJogadorResponse>> getListaJogadores(Pageable page) {
        Page<DetalheJogadorResponse> pagina = service.listarJogadores(page);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheJogadorResponse> buscarJogador(@PathVariable Long id) {
        var jogador = service.retornarJogador(id);
        return ResponseEntity.ok(
                new DetalheJogadorResponse(
                        jogador.idJogador(),
                        jogador.nomeJogador(),
                        jogador.pontuacaoJogador()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteJogador(@PathVariable Long id) {
        service.deletarJogador(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalheJogadorResponse> patchPontuacaoJogador(@PathVariable Long id, @RequestBody @Valid AtualizaPontosJogadorRequest pontos){
        var jogadorAtualizado = service.atualizarPontuacaoJogador(id, pontos.pontosJogador());
        return ResponseEntity.ok(
                new DetalheJogadorResponse(jogadorAtualizado));
    }
    //put para atualizar o Nome e email de jogador?
}


