package com.example.calculadoraucelo.model.capacidade;

public record CalculoCapacidadeResponse(
        Double capacidadeCalculada, // resultado (capacidade)
        String unidade // unidadade de medida para o resultado do calculo
) { }