package db1.pdi.api.jogador.controller;

import db1.pdi.api.jogador.controller.requests.AtribuiNacaoJogadorRequest;
import db1.pdi.api.jogador.controller.requests.CreateJogadorRequest;
import db1.pdi.api.jogador.controller.requests.AtualizaPontosJogadorRequest;
import db1.pdi.api.jogador.controller.response.utils.JogadorResponseMapper;
import db1.pdi.api.jogador.controller.response.DetalheJogadorResponse;
import db1.pdi.api.jogador.dto.JogadorDTO;
import db1.pdi.api.jogador.services.IJogadorService;


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

        JogadorDTO jogador = service.cadastrarJogador(
               JogadorDTO.builder()
                       .nomeJogador(request.nomeJogador())
                       .emailJogador(request.emailJogador())
                       .build());

        return ResponseEntity.status(HttpStatus.CREATED).body(
                JogadorResponseMapper.toResponse(jogador));
    }

    @GetMapping
    public ResponseEntity<Page<DetalheJogadorResponse>> getListaJogadores(Pageable page) {
        Page<DetalheJogadorResponse> pagina = service.listarJogadores(page).map(
                JogadorResponseMapper::toResponse);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheJogadorResponse> buscarJogador(@PathVariable Long id) {
        JogadorDTO jogador = service.retornarJogador(id);
        return ResponseEntity.ok(
                JogadorResponseMapper.toResponse(jogador));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteJogador(@PathVariable Long id) {
        service.deletarJogador(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalheJogadorResponse> patchPontuacaoJogador(@PathVariable Long id, @RequestBody AtualizaPontosJogadorRequest pontos){
        JogadorDTO jogador = service.atualizarPontuacaoJogador(id, pontos.pontosJogador());
        return ResponseEntity.ok(
                JogadorResponseMapper.toResponse(jogador));
    }

    @PatchMapping("/{idJogador}/nacao")
    @Transactional
    public ResponseEntity<DetalheJogadorResponse> putAtribuirNacao(@PathVariable Long idJogador, @RequestBody AtribuiNacaoJogadorRequest nacao){
        JogadorDTO jogador = service.atribuirNacaoAoJogador(idJogador, nacao.idNacao());
        return ResponseEntity.ok(
                JogadorResponseMapper.toResponse(jogador));
    }
}


