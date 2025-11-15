package com.example.calculadoraucelo.service.capacidade;

import com.example.calculadoraucelo.dto.capacidade.CapacidadeRequestDTO;
import com.example.calculadoraucelo.dto.capacidade.CapacidadeResponseDTO;
import org.springframework.stereotype.Service;

// Marca a classe como um service
@Service
public class CalculoCapacidadeService {

    // Método para calcular a capacidade
    public CapacidadeResponseDTO calcular(CapacidadeRequestDTO request) {
        // Pega os dados do request dto
        double velocidade = request.velocidade();
        double passo = request.passo();
        int numFileirasCorreia = request.numFileirasCorreia();
        double densidadeProduto =  request.densidadeProduto();
        double volumeCaneca =  request.volumeCaneca();
        double fatorEnchimento =  request.fatorEnchimento();
        double largura = request.largura();
        double projecao = request.projecao();
        double profundidade =   request.profundidade();

        double numCanecasPorMetro = (1000 / passo) * numFileirasCorreia;

        double capacidade = velocidade * numCanecasPorMetro * densidadeProduto * 3.6 / 1000 * fatorEnchimento;

        return new CapacidadeResponseDTO(capacidade, "t/h");
    }

}