package com.example.calculadoraucelo.service.capacidade;

import com.example.calculadoraucelo.dto.capacidade.CapacidadeRequestDTO;
import com.example.calculadoraucelo.dto.capacidade.CapacidadeResponseDTO;
import com.example.calculadoraucelo.model.Relatorio;
import com.example.calculadoraucelo.model.capacidade.Capacidade;
import com.example.calculadoraucelo.repository.CapacidadeRepository;
import com.example.calculadoraucelo.repository.RelatorioRepository;
import com.example.calculadoraucelo.util.RelatorioPdfHelper;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;

@Service
public class RelatorioCapacidadeService {

    // variavel estatica para tipo do calculo
    public static final String TIPO_CALCULO = "CAPACIDADE";

    // service do calculo de capacidade
    @Autowired
    private CalculoCapacidadeService calculoService;

    // injeta o repository de capacidade
    @Autowired
    private CapacidadeRepository capacidadeRepository;

    // service do helper de formatação pdf
    @Autowired
    private RelatorioPdfHelper helper; // injetando o pdf helper

    @Autowired
    private RelatorioRepository relatorioRepository;

    // metodo para gerar o relatorio
    public ByteArrayInputStream gerarRelatorio(Long idCalculo, String cnpj) {
        // busca o calculo pelo id
        Capacidade calculo = capacidadeRepository.findById(idCalculo)
                .orElseThrow(() -> new RuntimeException("ERRO: Cálculo não encontrado."));

        // verifica se o calculo foi feito pelo usuário logado
        if(!calculo.getUsuario().getCnpj().equals(cnpj)) {
            // se não for, lança exceção
            throw new RuntimeException("Você não possui acesso a esse relatório.");
        }

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
            helper.addDado(document, "Velocidade (m/s)", calculo.getVelocidade());
            helper.addDado(document, "Passo (mm)", calculo.getPasso());
            helper.addDado(document, "N° de fileiras de correia", calculo.getNumFileirasCorreia());
            helper.addDado(document, "Profundidade (mm)", calculo.getProfundidade());
            helper.addDado(document, "Volume da caneca (l)", calculo.getVolumeCaneca());
            helper.addDado(document, "Fator de enchimento (%)", calculo.getFatorEnchimento());
            helper.addDado(document, "Largura (mm)", calculo.getLargura());
            helper.addDado(document, "Projeção (mm)", calculo.getProjecao());
            helper.addDado(document, "Densidade do produto (kg/m³)", calculo.getDensidadeProduto());

            // adiciona espaçamento
            helper.addEspaco(document);

            // parte que exibe o resultado
            helper.addSubtitulo(document, "Resultado do Cálculo:");
            String resultadoFormatado = String.format("%.2f %s", calculo.getCapacidadeCalculada(), calculo.getUnidade());
            helper.addResultado(document, "Capacidade Calculada: " + resultadoFormatado);

            document.close();

            // cria uma nova instancia de relatorio e seta os dados necessarios
            Relatorio novoRelatorio = new Relatorio();
            novoRelatorio.setIdCalculo(calculo.getId());
            novoRelatorio.setDataGeracao(LocalDateTime.now());
            novoRelatorio.setTipoCalculo(TIPO_CALCULO);

            // salva o relatorio no historico do banco
            relatorioRepository.save(novoRelatorio);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

}
