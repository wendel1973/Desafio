package com.ordem.Desafio.controller;

import com.ordem.Desafio.domain.model.OrdemServico;
import com.ordem.Desafio.domain.service.OrdemServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/ordem")
public class OrdemServicoController {

    private final OrdemServicoService ordemServicoService;


    public OrdemServicoController(OrdemServicoService ordemServicoService) {
        this.ordemServicoService = ordemServicoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> findById(@PathVariable Long id) {
        var ordem = ordemServicoService.FindById(id);
        return ResponseEntity.ok(ordem);
    }
    @PostMapping
    public ResponseEntity<OrdemServico> create(@RequestBody OrdemServico ordemServicoToCreated) {
        var ordemServicoCreated = ordemServicoService.create(ordemServicoToCreated);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ordemServicoCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(ordemServicoCreated);
    }
}
