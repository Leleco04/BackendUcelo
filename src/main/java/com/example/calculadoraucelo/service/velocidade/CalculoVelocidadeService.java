package com.example.calculadoraucelo.service.velocidade;

import com.example.calculadoraucelo.model.velocidade.CalculoVelocidadeRequest;
import com.example.calculadoraucelo.model.velocidade.CalculoVelocidadeResponse;
import org.springframework.stereotype.Service;

@Service
public class CalculoVelocidadeService {

    public static final double PI = 3.14;

    public CalculoVelocidadeResponse calcular(CalculoVelocidadeRequest calculoVelocidadeRequest) {
        double oDoTambor = calculoVelocidadeRequest.oDoTambor();
        double rotacaoDoTambor = calculoVelocidadeRequest.rotacaoDoTambor();

        double velocidade = oDoTambor * rotacaoDoTambor * (PI / (60*1000));

        return new CalculoVelocidadeResponse(velocidade,"m/s");
    }
}