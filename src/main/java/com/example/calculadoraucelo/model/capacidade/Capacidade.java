package com.example.calculadoraucelo.model.capacidade;

import com.example.calculadoraucelo.model.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="historico_capacidade")
public class Capacidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cnpj")
    private Usuario usuario;

    @Column(name = "velocidade") //
    private Double velocidade;

    @Column(name = "passo") //
    private Double passo;

    @Column(name="numero_fileiras") // Correto
    private Integer numFileirasCorreia;

    @Column(name = "densidade_produto") //
    private Double densidadeProduto;

    @Column(name = "volume_caneca") //
    private Double volumeCaneca;

    @Column(name = "fator_enchimento") //
    private Double fatorEnchimento;

    @Column(name = "largura") //
    private Double largura;

    @Column(name = "projecao") //
    private Double projecao;

    @Column(name = "profundidade") //
    private Double profundidade;

    @Column(name = "capacidade_calculada") //
    private Double capacidadeCalculada;

    @Column(name = "unidade") //
    private String unidade;

    private LocalDateTime dataCalculo;

    public void CalculoCapacidade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }

    public Double getPasso() {
        return passo;
    }

    public void setPasso(Double passo) {
        this.passo = passo;
    }

    public Integer getNumFileirasCorreia() {
        return numFileirasCorreia;
    }

    public void setNumFileirasCorreia(Integer numFileirasCorreia) {
        this.numFileirasCorreia = numFileirasCorreia;
    }

    public Double getDensidadeProduto() {
        return densidadeProduto;
    }

    public void setDensidadeProduto(Double densidadeProduto) {
        this.densidadeProduto = densidadeProduto;
    }

    public Double getVolumeCaneca() {
        return volumeCaneca;
    }

    public void setVolumeCaneca(Double volumeCaneca) {
        this.volumeCaneca = volumeCaneca;
    }

    public Double getFatorEnchimento() {
        return fatorEnchimento;
    }

    public void setFatorEnchimento(Double fatorEnchimento) {
        this.fatorEnchimento = fatorEnchimento;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getProjecao() {
        return projecao;
    }

    public void setProjecao(Double projecao) {
        this.projecao = projecao;
    }

    public Double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(Double profundidade) {
        this.profundidade = profundidade;
    }

    public Double getCapacidadeCalculada() {
        return capacidadeCalculada;
    }

    public void setCapacidadeCalculada(Double capacidadeCalculada) {
        this.capacidadeCalculada = capacidadeCalculada;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public LocalDateTime getDataCalculo() {
        return dataCalculo;
    }

    public void setDataCalculo(LocalDateTime dataCalculo) {
        this.dataCalculo = dataCalculo;
    }
}
