package com.example.calculadoraucelo.util;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// servico para formatar o pdf
@Service
public class RelatorioPdfHelper {
    // define a estilização do titulo, subtitulo, resultado e corpo do pdf
    private final Font FONT_TITLE = new Font(Font.HELVETICA, 24, Font.BOLD);
    private final Font FONT_SUBTITLE = new Font(Font.HELVETICA, 20, Font.BOLD, new Color(0, 0, 0));
    private final Font FONT_RESULT = new Font(Font.HELVETICA, 16, Font.BOLD, new Color(150, 0, 0));
    private final Font FONT_BODY = new Font(Font.HELVETICA, 12, Font.NORMAL);

    // metodo para criar e adicionar o titulo
    public void addTitulo(Document document, String text) {
        // cria um novo paragrafo usando o texto (passado por parametro) e a estilização
        Paragraph p = new Paragraph(text, FONT_TITLE);
        // alinha o titulo no centro
        p.setAlignment(Paragraph.ALIGN_CENTER);
        // adiciona ao documento
        document.add(p);
    }

    // metodo para criar e adicionar o subtitulo
    public void addSubtitulo(Document document, String text) {
        // cria um novo paragrafo para o subtitulo
        Paragraph p = new Paragraph(text, FONT_SUBTITLE);
        // define um espacamento antes
        p.setSpacingBefore(10f);
        // define um espacamento depois
        p.setSpacingAfter(5f);
        // adiciona ao documento
        document.add(p);
    }

    // metodo para criar e adicionar o resultado
    public void addResultado(Document document, String text) {
        // cria um novo paragrafo com o resultado
        Paragraph p = new Paragraph(text, FONT_RESULT);
        // seta um espacamento antes
        p.setSpacingBefore(10f);
        // adiciona ao documento
        document.add(p);
    }

    public void addDado(Document document, String key, Object value) {
        String text = String.format("%s: %s", key, value.toString());
        Paragraph p = new Paragraph(text, FONT_BODY);
        // adiciona ao documento
        document.add(p);
    }

    // metodo para adicionar data ao documento
    public void addTimestamp(Document document) {
        // cria o formatador de data
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        // cria a data usando o formador e datetime atual
        Paragraph data = new Paragraph("Gerado em: " + dtf.format(LocalDateTime.now()));
        // alinha no centro
        data.setAlignment(Paragraph.ALIGN_CENTER);
        // adiciona ao documento
        document.add(data);
    }

    // metodo para adicionar espaco
    public void addEspaco(Document document) {
        // adiciona uma linha em branco no documento
        document.add(new Paragraph(" ")); // adiciona linha em branco
    }

    // metodo para carregar a imagem (logo)
    private Image carregarLogo(String logoPath) throws IOException, BadElementException {
        // usa o ClassPathResource para carregar a imagem
        ClassPathResource res = new ClassPathResource(logoPath);

        byte[] logoData;

        try (InputStream inputStream = res.getInputStream()) {
            logoData = inputStream.readAllBytes();
        }

        return Image.getInstance(logoData);
    }

    // cria a header do pdf
    public PdfPTable criarCabecalho(String logoPath, String tituloTexto) {
        try {
            // tabela da header com 2 celulas
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(100);
            headerTable.setWidths(new float[]{15f, 85f});

            // logo da empresa
            Image logo = carregarLogo(logoPath);
            logo.scaleToFit(80, 80);

            // adiciona a primeira celula (logo)
            PdfPCell logoCell = new PdfPCell(logo);
            logoCell.setBorder(Rectangle.NO_BORDER);
            logoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            logoCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            headerTable.addCell(logoCell);

            // adiciona a segunda celula (titulo)
            Paragraph title = new Paragraph(tituloTexto, FONT_TITLE);
            title.setAlignment(Element.ALIGN_LEFT);

            PdfPCell titleCell = new PdfPCell(title);
            titleCell.setBorder(Rectangle.NO_BORDER);
            titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            titleCell.setPaddingLeft(10);
            headerTable.addCell(titleCell);

            // retorna a header
            return headerTable;

        } catch (Exception e) {
            e.printStackTrace();
            return new PdfPTable(1);
        }
    }

}