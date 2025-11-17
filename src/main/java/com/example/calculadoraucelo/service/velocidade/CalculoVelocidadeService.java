package com.example.calculadoraucelo.service.velocidade;

import com.example.calculadoraucelo.dto.velocidade.VelocidadeRequestDTO;
import com.example.calculadoraucelo.dto.velocidade.VelocidadeResponseDTO;
import com.example.calculadoraucelo.model.usuario.Usuario;
import com.example.calculadoraucelo.model.velocidade.Velocidade;
import com.example.calculadoraucelo.repository.UsuarioRepository;
import com.example.calculadoraucelo.repository.VelocidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculoVelocidadeService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VelocidadeRepository velocidadeRepository;

    public static final double PI = 3.14;

    public VelocidadeResponseDTO calcular(VelocidadeRequestDTO velocidadeRequestDTO, String cnpj) {
        double diametroTambor = velocidadeRequestDTO.diametroTambor();
        double rotacaoDoTambor = velocidadeRequestDTO.rotacaoDoTambor();

        // faz o calculo e define a unidade de medida
        double velocidade = diametroTambor * rotacaoDoTambor * (PI / (60*1000));
        String unidade = "m/s";

        // busca o usuario pelo cnpj
        Usuario usuario = usuarioRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // seta os dados na entidade criada
        Velocidade velocidadeCalculada = new Velocidade();
        velocidadeCalculada.setUsuario(usuario);
        velocidadeCalculada.setDiametroTambor(diametroTambor);
        velocidadeCalculada.setRotacaoDoTambor(rotacaoDoTambor);
        velocidadeCalculada.setVelocidadeCalculada(velocidade);
        velocidadeCalculada.setUnidade(unidade);

        // salva o calculo no banco
        velocidadeRepository.save(velocidadeCalculada);

        return new VelocidadeResponseDTO(velocidade,unidade);
    }
}