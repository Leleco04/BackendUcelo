package com.example.calculadoraucelo.repository;

import com.example.calculadoraucelo.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByCnpj(String cnpj);

    boolean existsByCnpj(String cnpj);
}