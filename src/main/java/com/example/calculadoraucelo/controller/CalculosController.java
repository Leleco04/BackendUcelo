package com.example.calculadoraucelo.controller;

import com.example.calculadoraucelo.model.capacidade.CalculoCapacidadeRequest;
import com.example.calculadoraucelo.model.capacidade.CalculoCapacidadeResponse;
import com.example.calculadoraucelo.model.velocidade.CalculoVelocidadeRequest;
import com.example.calculadoraucelo.model.velocidade.CalculoVelocidadeResponse;
import com.example.calculadoraucelo.service.capacidade.CalculoCapacidadeService;
import com.example.calculadoraucelo.service.capacidade.RelatorioCapacidadeService;
import com.example.calculadoraucelo.service.velocidade.CalculoVelocidadeService;
import com.example.calculadoraucelo.service.velocidade.RelatorioVelocidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

// Identifica como um controller
@RestController
// Rota base da api
@RequestMapping("/api/calculos")
// Permite que a rota do angular acesse a API
@CrossOrigin(origins = "http://localhost:4200")
public class CalculosController {

    @Autowired
    private CalculoCapacidadeService calculoCapacidadeService;

    @Autowired
    private RelatorioCapacidadeService relatorioCapacidadeService;

    @Autowired
    private RelatorioVelocidadeService relatorioVelocidadeService;

    @Autowired
    private CalculoVelocidadeService calculoVelocidadeService;

    // Rota post para a api (/api/calculos/capacidade)
    @PostMapping("/capacidade")
    public ResponseEntity<CalculoCapacidadeResponse> calcularCapacidade(@RequestBody CalculoCapacidadeRequest calculoCapacidadeRequest){
        CalculoCapacidadeResponse response = calculoCapacidadeService.calcular(calculoCapacidadeRequest);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/capacidade/relatorio")
    public ResponseEntity<InputStreamResource> gerarRelatorio(@RequestBody CalculoCapacidadeRequest calculoCapacidadeRequest) {
        ByteArrayInputStream pdf = relatorioCapacidadeService.gerarRelatorio(calculoCapacidadeRequest);

        // 2. Prepara os Headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=relatorio-capacidade.pdf");

        // 3. Retorna o arquivo PDF
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }

    @PostMapping("/velocidade")
    public ResponseEntity<CalculoVelocidadeResponse> calcularVelocidade(@RequestBody CalculoVelocidadeRequest calculoVelocidadeRequest){
        CalculoVelocidadeResponse response = calculoVelocidadeService.calcular(calculoVelocidadeRequest);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/velocidade/relatorio")
    public ResponseEntity<InputStreamResource> gerarRelatorio(@RequestBody CalculoVelocidadeRequest calculoVelocidadeRequest) {
        ByteArrayInputStream pdf = relatorioVelocidadeService.gerarRelatorio(calculoVelocidadeRequest);

        // 2. Prepara os Headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=relatorio-velocidade.pdf");

        // 3. Retorna o arquivo PDF
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }

}