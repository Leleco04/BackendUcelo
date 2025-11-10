package com.example.calculadoraucelo.model.capacidade;

public record CalculoCapacidadeRequest(
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