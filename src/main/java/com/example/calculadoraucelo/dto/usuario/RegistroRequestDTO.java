package com.example.calculadoraucelo.dto.usuario;

public record RegistroRequestDTO(
        String cnpj,
        String nomeEmpresa,
        String email,
        String telefone,
        String senha
) {
}
