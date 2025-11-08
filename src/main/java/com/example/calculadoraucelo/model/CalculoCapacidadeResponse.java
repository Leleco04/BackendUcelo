package com.example.calculadoraucelo.model;

public record CalculoCapacidadeResponse(
        Double capacidadeCalculada, // resultado (capacidade)
        String unidade // unidadade de medida para o resultado do calculo
) { }