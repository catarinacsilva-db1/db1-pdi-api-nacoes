package db1.pdi.api.controller;

import db1.pdi.api.dto.GetNacaoDTO;
import db1.pdi.api.dto.NacaoDTO;
import db1.pdi.api.services.INacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nacoes")
public class NacaoController {

    @Autowired
    INacaoService service;

    @PostMapping
    @Transactional
    public void postNacao(@RequestBody @Valid NacaoDTO nacaoDTO) {
        service.cadastrarNacao(nacaoDTO);
    }

    @GetMapping
    public Page<GetNacaoDTO> getListaNacoes(Pageable page) {
        return service.listarNacoes(page);
    }

    @GetMapping("/{id}")
    public GetNacaoDTO getNacao(@PathVariable Long id) {
        return service.retornarNacao(id);
        //adicionar retorno de lista de jogadores da nação
    }
}
