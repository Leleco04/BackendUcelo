package com.example.calculadoraucelo.controller.calculo;

import com.example.calculadoraucelo.dto.capacidade.CapacidadeRequestDTO;
import com.example.calculadoraucelo.dto.capacidade.CapacidadeResponseDTO;
import com.example.calculadoraucelo.dto.velocidade.VelocidadeRequestDTO;
import com.example.calculadoraucelo.dto.velocidade.VelocidadeResponseDTO;
import com.example.calculadoraucelo.model.capacidade.Capacidade;
import com.example.calculadoraucelo.model.usuario.Usuario;
import com.example.calculadoraucelo.model.velocidade.Velocidade;
import com.example.calculadoraucelo.repository.CapacidadeRepository;
import com.example.calculadoraucelo.repository.VelocidadeRepository;
import com.example.calculadoraucelo.service.capacidade.CalculoCapacidadeService;
import com.example.calculadoraucelo.service.capacidade.RelatorioCapacidadeService;
import com.example.calculadoraucelo.service.usuario.UsuarioService;
import com.example.calculadoraucelo.service.velocidade.CalculoVelocidadeService;
import com.example.calculadoraucelo.service.velocidade.RelatorioVelocidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

// Identifica como um controller
@RestController
// Rota base da api
@RequestMapping("/api/calculos")
// Permite que a rota do angular acesse a API
// @CrossOrigin(origins = "http://localhost:4200")
public class CalculosController {
    @Autowired
    private CalculoCapacidadeService calculoCapacidadeService;

    @Autowired
    private CapacidadeRepository capacidadeRepository;

    @Autowired
    private VelocidadeRepository velocidadeRepository;

    @Autowired
    private RelatorioCapacidadeService relatorioCapacidadeService;

    @Autowired
    private RelatorioVelocidadeService relatorioVelocidadeService;

    @Autowired
    private CalculoVelocidadeService calculoVelocidadeService;
    @Autowired
    private UsuarioService usuarioService;

    // Rota post para a api (/api/calculos/capacidade)
    @PostMapping("/capacidade")
    public ResponseEntity<CapacidadeResponseDTO> calcularCapacidade(@RequestBody CapacidadeRequestDTO capacidadeRequestDTO){
        CapacidadeResponseDTO response = calculoCapacidadeService.calcular(capacidadeRequestDTO, getCnpjUsuario());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/capacidade/relatorio")
    public ResponseEntity<InputStreamResource> gerarRelatorio(@RequestBody CapacidadeRequestDTO capacidadeRequestDTO) {
        ByteArrayInputStream pdf = relatorioCapacidadeService.gerarRelatorio(capacidadeRequestDTO, getCnpjUsuario());

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
    public ResponseEntity<VelocidadeResponseDTO> calcularVelocidade(@RequestBody VelocidadeRequestDTO velocidadeRequestDTO){
        VelocidadeResponseDTO response = calculoVelocidadeService.calcular(velocidadeRequestDTO, getCnpjUsuario());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/velocidade/relatorio")
    public ResponseEntity<InputStreamResource> gerarRelatorio(@RequestBody VelocidadeRequestDTO velocidadeRequestDTO) {
        ByteArrayInputStream pdf = relatorioVelocidadeService.gerarRelatorio(velocidadeRequestDTO, getCnpjUsuario());

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

    @GetMapping("/capacidade/historico")
    public ResponseEntity<Page<Capacidade>> getHistoricoCapacidade(
            @AuthenticationPrincipal Usuario usuarioLogado,
            Pageable pageable // O Spring monta isso automaticamente
    ) {
        Page<Capacidade> historico = capacidadeRepository.findByUsuarioCnpj(
                usuarioLogado.getCnpj(),
                pageable
        );
        return ResponseEntity.ok(historico);
    }

    @GetMapping("/velocidade/historico")
    public ResponseEntity<Page<Velocidade>> getHistoricoVelocidade(
            @AuthenticationPrincipal Usuario usuarioLogado,
            Pageable pageable
    ) {
        Page<Velocidade> historico = velocidadeRepository.findByUsuarioCnpj(
                usuarioLogado.getCnpj(),
                pageable
        );
        return ResponseEntity.ok(historico);
    }

    // método para pegar o CNPJ do usuário autenticado
    public String getCnpjUsuario() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}