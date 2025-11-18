package com.example.calculadoraucelo.controller.calculo;

import com.example.calculadoraucelo.model.Caneca;
import com.example.calculadoraucelo.service.comparacao.CanecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// identifica a classe como controller
@RestController
// rota base da api
@RequestMapping("/api/canecas")
public class CanecaController {

    // Injeta o service de canecas
    @Autowired
    private CanecaService canecaService;

    // rota do tipo get
    // /api/canecas/todas
    @GetMapping("/todas")
    // metodo para retornar todas as canecas
    public ResponseEntity<List<Caneca>> buscarCanecas() {
        // busca as canecas e salva em uma lista, usando o service
        List<Caneca> canecas = canecaService.buscarCanecas();

        // se nao tiver vazio (achou canecas), retorna a lista
        if (!canecas.isEmpty()) {
            return ResponseEntity.ok(canecas);
        }

        // caso nao tenha canecas, retorna o status bad request (400)
        return ResponseEntity.badRequest().build();
    }

}
