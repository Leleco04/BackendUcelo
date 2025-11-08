package com.example.calculadoraucelo.controller;

import com.example.calculadoraucelo.model.CalculoCapacidadeRequest;
import com.example.calculadoraucelo.model.CalculoCapacidadeResponse;
import com.example.calculadoraucelo.service.CalculoCapacidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Identifica como um controller
@RestController
// Rota base da api
@RequestMapping("/api/calculos")
// Permite que a rota do angular acesse a API
@CrossOrigin(origins = "http://localhost:4200")
public class CalculoCapacidadeController {

    @Autowired
    private CalculoCapacidadeService calculoCapacidadeService;

    // Rota post para a api (/api/calculos/capacidade)
    @PostMapping("/capacidade")
    public ResponseEntity<CalculoCapacidadeResponse> calcular(
            @RequestBody CalculoCapacidadeRequest calculoCapacidadeRequest
    ){
        CalculoCapacidadeResponse response = calculoCapacidadeService.calcular(calculoCapacidadeRequest);

        return ResponseEntity.ok(response);
    }

}
