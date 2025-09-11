package db1.pdi.api.controller.jogador;

import db1.pdi.api.controller.jogador.requests.CreateJogadorRequest;
import db1.pdi.api.controller.jogador.requests.AtualizaPontosJogadorRequest;
import db1.pdi.api.controller.jogador.response.ResponseMapper;
import db1.pdi.api.domain.jogador.entities.JogadorDomain;
import db1.pdi.api.controller.jogador.response.DetalheJogadorResponse;
import db1.pdi.api.domain.jogador.services.IJogadorService;
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
        JogadorDomain jogador = service.cadastrarJogador(
                new JogadorDomain(
                request.nomeJogador(),
                request.emailJogador()));

        return ResponseEntity.status(HttpStatus.CREATED).body(
                ResponseMapper.toResponse(jogador));
    }

    @GetMapping
    public ResponseEntity<Page<DetalheJogadorResponse>> getListaJogadores(Pageable page) {
        Page<DetalheJogadorResponse> pagina = service.listarJogadores(page).map(
                ResponseMapper::toResponse);

        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheJogadorResponse> buscarJogador(@PathVariable Long id) {
        JogadorDomain jogador = service.retornarJogador(id);

        return ResponseEntity.ok(
                ResponseMapper.toResponse(jogador));
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
        JogadorDomain jogador = service.atualizarPontuacaoJogador(id, pontos.pontosJogador());

        return ResponseEntity.ok(
                ResponseMapper.toResponse(jogador));
    }
}


