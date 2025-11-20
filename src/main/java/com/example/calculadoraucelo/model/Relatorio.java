package com.example.calculadoraucelo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="historico_relatorios")
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long idCalculo;
    private String tipoCalculo;
    private LocalDateTime dataGeracao;

    public void Relatorio() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCalculo() {
        return idCalculo;
    }

    public void setIdCalculo(long idCalculo) {
        this.idCalculo = idCalculo;
    }

    public String getTipoCalculo() {
        return tipoCalculo;
    }

    public void setTipoCalculo(String tipoCalculo) {
        this.tipoCalculo = tipoCalculo;
    }

    public LocalDateTime getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDateTime dataGeracao) {
        this.dataGeracao = dataGeracao;
    }
}
