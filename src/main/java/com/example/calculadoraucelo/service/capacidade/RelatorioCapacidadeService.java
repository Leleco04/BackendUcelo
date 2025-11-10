package com.example.calculadoraucelo.service.capacidade;

import com.example.calculadoraucelo.model.capacidade.CalculoCapacidadeRequest;
import com.example.calculadoraucelo.model.capacidade.CalculoCapacidadeResponse;
import com.example.calculadoraucelo.util.RelatorioPdfHelper;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class RelatorioCapacidadeService {

    // service do calculo de capacidade
    @Autowired
    private CalculoCapacidadeService calculoService;

    // service do helper de formatação pdf
    @Autowired
    private RelatorioPdfHelper helper; // injetando o pdf helper

    // metodo para gerar o relatorio
    public ByteArrayInputStream gerarRelatorio(CalculoCapacidadeRequest request) {
        // antes de tudo calcula o resultado
        CalculoCapacidadeResponse response = calculoService.calcular(request);

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
            PdfPTable cabecalho = helper.criarCabecalho(logoPath, "Relatório de Cálculo de Capacidade");

            // adiciona a header ao documento
            document.add(cabecalho);

            // adiciona o timestamp e um espaçamento
            helper.addTimestamp(document);
            helper.addEspaco(document);

            // dados de entrada para o body
            helper.addSubtitulo(document, "Dados de Entrada:");
            helper.addDado(document, "Velocidade (m/s)", request.velocidade());
            helper.addDado(document, "Passo (mm)", request.passo());
            helper.addDado(document, "N° de fileiras de correia", request.numFileirasCorreia());
            helper.addDado(document, "Profundidade (mm)", request.profundidade());
            helper.addDado(document, "Volume da caneca (l)", request.volumeCaneca());
            helper.addDado(document, "Fator de enchimento (%)", request.fatorEnchimento());
            helper.addDado(document, "Largura (mm)", request.largura());
            helper.addDado(document, "Projeção (mm)", request.projecao());
            helper.addDado(document, "Densidade do produto (kg/m³)", request.densidadeProduto());

            // adiciona espaçamento
            helper.addEspaco(document);

            // parte que exibe o resultado
            helper.addSubtitulo(document, "Resultado do Cálculo:");
            String resultadoFormatado = String.format("%.2f %s", response.capacidadeCalculada(), response.unidade());
            helper.addResultado(document, "Capacidade Calculada: " + resultadoFormatado);

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

}
