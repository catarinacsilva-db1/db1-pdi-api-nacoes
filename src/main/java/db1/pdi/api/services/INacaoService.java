package db1.pdi.api.services;

import db1.pdi.api.dto.GetNacaoDTO;
import db1.pdi.api.dto.NacaoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INacaoService {
    void cadastrarNacao(NacaoDTO nacaoDTO);

    Page<GetNacaoDTO> listarNacoes(Pageable page);

    GetNacaoDTO retornarNacao(Long id);
}
