package com.example.calculadoraucelo.repository;

import com.example.calculadoraucelo.model.velocidade.Velocidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VelocidadeRepository extends JpaRepository<Velocidade,Long> {
    Page<Velocidade> findByUsuarioCnpj(String cnpj, Pageable pageable);
}
