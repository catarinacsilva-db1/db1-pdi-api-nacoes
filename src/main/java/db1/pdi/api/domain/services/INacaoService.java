package db1.pdi.api.domain.services;

import db1.pdi.api.controller.response.DetalheNacaoResponse;
import db1.pdi.api.dto.NacaoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INacaoService {
    void cadastrarNacao(NacaoDTO nacaoDTO);

    Page<DetalheNacaoResponse> listarNacoes(Pageable page);

    DetalheNacaoResponse retornarNacao(Long id);
}
