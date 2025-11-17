package com.example.calculadoraucelo.model;

import jakarta.persistence.*;

@Entity
@Table(name="caneca")
public class Caneca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_caneca")
    private Long id;

    private String nomeModelo;
    private double volumeCaneca;
    private String material;
    private double capacidade;
    private double volumeBorda;
    private double enchimento;
    private double resistenciaBrasao;
    private double resistenciaTracao;
    private double deslocamento;
    private double profundidade;
    private double largura;
    private double projecao;
    private double velocidade;
    private double densidade;
    private int numeroDeFileiras;
    private int canecasMetro;
    private double passo;

    public void Caneca() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public double getVolumeCaneca() {
        return volumeCaneca;
    }

    public void setVolumeCaneca(double volumeCaneca) {
        this.volumeCaneca = volumeCaneca;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public double getVolumeBorda() {
        return volumeBorda;
    }

    public void setVolumeBorda(double volumeBorda) {
        this.volumeBorda = volumeBorda;
    }

    public double getEnchimento() {
        return enchimento;
    }

    public void setEnchimento(double enchimento) {
        this.enchimento = enchimento;
    }

    public double getResistenciaBrasao() {
        return resistenciaBrasao;
    }

    public void setResistenciaBrasao(double resistenciaBrasao) {
        this.resistenciaBrasao = resistenciaBrasao;
    }

    public double getResistenciaTracao() {
        return resistenciaTracao;
    }

    public void setResistenciaTracao(double resistenciaTracao) {
        this.resistenciaTracao = resistenciaTracao;
    }

    public double getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(double deslocamento) {
        this.deslocamento = deslocamento;
    }

    public double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getProjecao() {
        return projecao;
    }

    public void setProjecao(double projecao) {
        this.projecao = projecao;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getDensidade() {
        return densidade;
    }

    public void setDensidade(double densidade) {
        this.densidade = densidade;
    }

    public int getNumeroDeFileiras() {
        return numeroDeFileiras;
    }

    public void setNumeroDeFileiras(int numeroDeFileiras) {
        this.numeroDeFileiras = numeroDeFileiras;
    }

    public int getCanecasMetro() {
        return canecasMetro;
    }

    public void setCanecasMetro(int canecasMetro) {
        this.canecasMetro = canecasMetro;
    }

    public double getPasso() {
        return passo;
    }

    public void setPasso(double passo) {
        this.passo = passo;
    }
}
