package com.ordem.Desafio.domain.service.impl;

import java.util.NoSuchElementException;
import com.ordem.Desafio.domain.model.OrdemServico;
import com.ordem.Desafio.domain.repository.OrdemServicoRepository;
import com.ordem.Desafio.domain.service.OrdemServicoService;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoServicImpl implements OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;

    public OrdemServicoServicImpl(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    @Override
    public OrdemServico FindById(Long id) {
        return ordemServicoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }


    @Override
    public OrdemServico create(OrdemServico ordemToCreate) {

        return ordemServicoRepository.save(ordemToCreate);
    }
}
