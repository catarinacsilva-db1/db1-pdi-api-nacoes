package db1.pdi.api.controller.nacao;

import db1.pdi.api.controller.nacao.request.CreateNacaoRequest;
import db1.pdi.api.controller.nacao.response.DetalheNacaoResponse;
import db1.pdi.api.controller.nacao.response.ListarNacaoResponse;
import db1.pdi.api.controller.nacao.response.utils.NacaoResponseMapper;
import db1.pdi.api.domain.nacao.entities.NacaoDomain;
import db1.pdi.api.domain.nacao.entities.NacaoDomainFactory;
import db1.pdi.api.domain.nacao.services.INacaoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/nacoes")
public class NacaoController {

    @Autowired
    INacaoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<ListarNacaoResponse> cadastrarNacao (@RequestBody CreateNacaoRequest request) {
        NacaoDomain nacao = service.cadastrarNacao(NacaoDomainFactory.create(request.nomeNacao()));
        return ResponseEntity.ok(NacaoResponseMapper.toResponseList(nacao));
    }

    @GetMapping
    public ResponseEntity<Page<ListarNacaoResponse>> rankearNacoes(Pageable page) {
        Page<ListarNacaoResponse> nacoes = service.listarRankingNacoes(page).map(NacaoResponseMapper::toResponseList);
        return ResponseEntity.ok(nacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheNacaoResponse> buscarNacao(@PathVariable Long id) {
        NacaoDomain nacao = service.retornarNacao(id);
        return ResponseEntity.ok(NacaoResponseMapper.toResponse(nacao));
    }
}
