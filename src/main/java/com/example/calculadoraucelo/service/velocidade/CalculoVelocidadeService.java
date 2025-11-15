package com.example.calculadoraucelo.service.velocidade;

import com.example.calculadoraucelo.dto.velocidade.VelocidadeRequestDTO;
import com.example.calculadoraucelo.dto.velocidade.VelocidadeResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculoVelocidadeService {

    public static final double PI = 3.14;

    public VelocidadeResponseDTO calcular(VelocidadeRequestDTO velocidadeRequestDTO) {
        double oDoTambor = velocidadeRequestDTO.oDoTambor();
        double rotacaoDoTambor = velocidadeRequestDTO.rotacaoDoTambor();

        double velocidade = oDoTambor * rotacaoDoTambor * (PI / (60*1000));

        return new VelocidadeResponseDTO(velocidade,"m/s");
    }
}