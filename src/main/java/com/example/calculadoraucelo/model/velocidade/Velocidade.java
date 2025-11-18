package com.example.calculadoraucelo.model.velocidade;

import com.example.calculadoraucelo.model.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="historico_velocidade")
public class Velocidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cnpj")
    private Usuario usuario;

    private double diametroTambor;

    @Column(name="rotacao_tambor")
    private double rotacaoDoTambor;

    private double velocidadeCalculada;
    private String unidade;

    private LocalDateTime dataCalculo;

    public void Velocidade() {}

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

    public double getDiametroTambor() {
        return diametroTambor;
    }

    public void setDiametroTambor(double diametroTambor) {
        this.diametroTambor = diametroTambor;
    }

    public double getRotacaoDoTambor() {
        return rotacaoDoTambor;
    }

    public void setRotacaoDoTambor(double rotacaoDoTambor) {
        this.rotacaoDoTambor = rotacaoDoTambor;
    }

    public double getVelocidadeCalculada() {
        return velocidadeCalculada;
    }

    public void setVelocidadeCalculada(double velocidadeCalculada) {
        this.velocidadeCalculada = velocidadeCalculada;
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
