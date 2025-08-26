package db1.pdi.api.controller;

import db1.pdi.api.controller.requests.CreateJogadorRequest;
import db1.pdi.api.dto.JogadorDTO;
import db1.pdi.api.dto.GetJogadorDTO;
import db1.pdi.api.dto.PontuacaoJogadorDTO;
import db1.pdi.api.services.IJogadorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/jogadores")
public class JogadorController {

 
    @Autowired
    IJogadorService service;

    @PostMapping
    @Transactional
    public void postJogador(@RequestBody @Valid CreateJogadorRequest request) {
        JogadorDTO jogadorDTO = new JogadorDTO(request.nomeJogador(), request.emailJogador(), 0L);
        service.cadastrarJogador(jogadorDTO);
    }

    @GetMapping
    public Page<GetJogadorDTO> getListaJogadores(Pageable page) {
        return service.listarJogadores(page);
    }

    @GetMapping("/{id}")
    public GetJogadorDTO getJogador(@PathVariable Long id) {
        return service.retornarJogador(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteJogador(@PathVariable Long id) {
        service.deletarJogador(id);}

    @PatchMapping("/{id}")
    @Transactional
    public void patchPontuacaoJogador(@PathVariable Long id, @RequestBody @Valid PontuacaoJogadorDTO pontos){
        service.atualizarPontuacaoJogador(id, pontos);
    }
    //put para atualizar o Nome e email de jogador?
}


