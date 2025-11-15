package com.example.calculadoraucelo.dto.capacidade;

public record CapacidadeRequestDTO(
        Double velocidade,
        Double passo,
        Integer numFileirasCorreia,
        Double densidadeProduto,
        Double volumeCaneca,
        Double fatorEnchimento,
        Double largura,
        Double projecao,
        Double profundidade
) { }