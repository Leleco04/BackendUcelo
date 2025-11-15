package com.example.calculadoraucelo.dto.capacidade;

public record CapacidadeResponseDTO(
        Double capacidadeCalculada, // resultado (capacidade)
        String unidade // unidadade de medida para o resultado do calculo
) { }