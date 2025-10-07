package db1.pdi.api.nacao.controller;

import db1.pdi.api.nacao.controller.request.CreateNacaoRequest;
import db1.pdi.api.nacao.controller.response.DetalheNacaoResponse;
import db1.pdi.api.nacao.controller.response.ListarNacaoResponse;
import db1.pdi.api.nacao.controller.response.utils.NacaoResponseMapper;
import db1.pdi.api.nacao.dto.NacaoDTO;
import db1.pdi.api.nacao.services.INacaoService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/nacoes")
public class NacaoController {

    @Autowired
    INacaoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<ListarNacaoResponse> cadastrarNacao (@RequestBody CreateNacaoRequest request) {
        NacaoDTO nacao = service.cadastrarNacao(new NacaoDTO(request.nomeNacao()));
        return ResponseEntity.ok(NacaoResponseMapper.toResponseList(nacao));
    }

    @GetMapping
    public ResponseEntity<List<ListarNacaoResponse>> rankearNacoes() {
        List<ListarNacaoResponse> nacoes = service.listarRankingNacoes().stream().map(NacaoResponseMapper::toResponseList).toList();
        return ResponseEntity.ok(nacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheNacaoResponse> buscarNacao(@PathVariable Long id) {
        NacaoDTO nacao = service.retornarNacao(id);
        return ResponseEntity.ok(NacaoResponseMapper.toResponse(nacao));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletarNacao(@PathVariable Long id) {
        service.deletarNacao(id);
        return ResponseEntity.ok().build();
    }


}
