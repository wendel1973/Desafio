package com.ordem.Desafio.domain.service;

import com.ordem.Desafio.domain.model.OrdemServico;

public interface OrdemServicoService {

    OrdemServico FindById(Long id);

    OrdemServico create(OrdemServico ordemToCreate);
}
