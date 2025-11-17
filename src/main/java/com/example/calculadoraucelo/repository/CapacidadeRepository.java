package com.example.calculadoraucelo.repository;

import com.example.calculadoraucelo.model.capacidade.Capacidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapacidadeRepository extends JpaRepository<Capacidade,Long> {
    Page<Capacidade> findByUsuarioCnpj(String cnpj, Pageable pageable);
}
