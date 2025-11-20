package com.example.calculadoraucelo.service.capacidade;

import com.example.calculadoraucelo.dto.capacidade.CapacidadeRequestDTO;
import com.example.calculadoraucelo.dto.capacidade.CapacidadeResponseDTO;
import com.example.calculadoraucelo.model.capacidade.Capacidade;
import com.example.calculadoraucelo.model.usuario.Usuario;
import com.example.calculadoraucelo.repository.CapacidadeRepository;
import com.example.calculadoraucelo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// Marca a classe como um service
@Service
public class CalculoCapacidadeService {

    // injeta o repository de usuario
    @Autowired
    private UsuarioRepository usuarioRepository;

    // injeta o repository de capacidade
    @Autowired
    private CapacidadeRepository capacidadeRepository;

    // Método para calcular a capacidade
    public CapacidadeResponseDTO calcular(CapacidadeRequestDTO request, String usuarioCnpj) {
        // Pega os dados do request dto
        double velocidade = request.velocidade();
        double passo = request.passo();
        int numFileirasCorreia = request.numFileirasCorreia();
        double densidadeProduto =  request.densidadeProduto();
        double volumeCaneca =  request.volumeCaneca();
        double fatorEnchimento =  request.fatorEnchimento();
        double largura = request.largura();
        double projecao = request.projecao();
        double profundidade =   request.profundidade();

        // calcula o numero de canecas por metro
        double numCanecasPorMetro = (1000 / passo) * numFileirasCorreia;

        // faz o calculo
        double capacidade = velocidade * numCanecasPorMetro * densidadeProduto * 3.6 / 1000 * fatorEnchimento;
        // define a unidade de medida do resultado
        String unidade = "t/h";

        // busca o usuário que fez o calculo pelo cnpj
        Usuario usuario = usuarioRepository.findByCnpj(usuarioCnpj)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        // Cria a nova entidade para salvar o calculo
        Capacidade novoCalculo = new Capacidade();
        novoCalculo.setUsuario(usuario);

        // seta todos os valores na entidade para salvar no banco
        novoCalculo.setVelocidade(velocidade);
        novoCalculo.setPasso(passo);
        novoCalculo.setNumFileirasCorreia(numFileirasCorreia);
        novoCalculo.setDensidadeProduto(densidadeProduto);
        novoCalculo.setVolumeCaneca(volumeCaneca);
        novoCalculo.setFatorEnchimento(fatorEnchimento);
        novoCalculo.setLargura(largura);
        novoCalculo.setProjecao(projecao);
        novoCalculo.setProfundidade(profundidade);
        novoCalculo.setCapacidadeCalculada(capacidade);
        novoCalculo.setUnidade(unidade);
        novoCalculo.setDataCalculo(LocalDateTime.now());

        // faz a inserção do novo calculo no banco
        capacidadeRepository.save(novoCalculo);

        // retorna a resposta json com capacidade e unidade de medida
        return new CapacidadeResponseDTO(novoCalculo.getId() ,capacidade, unidade);
    }

}