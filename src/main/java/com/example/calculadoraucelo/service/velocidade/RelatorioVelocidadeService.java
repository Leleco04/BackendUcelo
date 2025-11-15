package com.example.calculadoraucelo.service.velocidade;

import com.example.calculadoraucelo.dto.velocidade.VelocidadeRequestDTO;
import com.example.calculadoraucelo.dto.velocidade.VelocidadeResponseDTO;
import com.example.calculadoraucelo.util.RelatorioPdfHelper;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class RelatorioVelocidadeService {

    @Autowired
    private CalculoVelocidadeService calculoService;

    @Autowired
    private RelatorioPdfHelper helper;

    public ByteArrayInputStream gerarRelatorio(VelocidadeRequestDTO request) {
        // antes de tudo calcula o resultado
        VelocidadeResponseDTO response = calculoService.calcular(request);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // inicia um documento novo
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, out);
            // abre o documento
            document.open();

            // caminho da imagem (logo)
            String logoPath = "images/ucelo.png";

            // chama o helper para criar a header
            PdfPTable cabecalho = helper.criarCabecalho(logoPath, "Relatório de Cálculo de Velocidade");

            // adiciona a header ao documento
            document.add(cabecalho);

            // adiciona o timestamp e um espaçamento
            helper.addTimestamp(document);
            helper.addEspaco(document);

            // dados de entrada para o body
            helper.addSubtitulo(document, "Dados de Entrada:");
            helper.addDado(document, "Ø do tambor", request.oDoTambor());
            helper.addDado(document, "Rotação do tambor", request.rotacaoDoTambor());

            // adiciona espaçamento
            helper.addEspaco(document);

            // parte que exibe o resultado
            helper.addSubtitulo(document, "Resultado do Cálculo:");
            String resultadoFormatado = String.format("%.2f %s", response.velocidadeCalculada(), response.unidade());
            helper.addResultado(document, "Velocidade Calculada: " + resultadoFormatado);

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

}
