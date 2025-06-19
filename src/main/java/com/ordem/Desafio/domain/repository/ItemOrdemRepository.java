package com.ordem.Desafio.domain.repository;

import com.ordem.Desafio.domain.model.ItemOrdem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrdemRepository extends JpaRepository<ItemOrdem, Long> {
}
