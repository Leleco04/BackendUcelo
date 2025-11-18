package com.example.calculadoraucelo.service.usuario;

import com.example.calculadoraucelo.dto.usuario.RegistroRequestDTO;
import com.example.calculadoraucelo.model.usuario.Usuario;
import com.example.calculadoraucelo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// identifica como service
@Service
public class UsuarioService implements UserDetailsService {

    // injeta o repository de usuario
    @Autowired
    private UsuarioRepository usuarioRepository;

    // injeta o codificador de senhas
    @Autowired
    private PasswordEncoder passwordEncoder;

    // metodo para registrar o usuario
    public Usuario registrarUsuario(RegistroRequestDTO registroRequestDTO) {
        // Antes de fazer o cadastro, verifica se o cnpj já está registrado
        if(usuarioRepository.existsByCnpj(registroRequestDTO.cnpj())) {{
            // se ja tiver, lança uma excecao
            throw new RuntimeException("Erro: CNPJ já existente.");
        }}

        // cria uma nova instancia para o usuario novo
        Usuario usuarioNovo = new Usuario();

        // seta os dados do usuario
        usuarioNovo.setCnpj(registroRequestDTO.cnpj());
        usuarioNovo.setNomeEmpresa(registroRequestDTO.nomeEmpresa());
        usuarioNovo.setEmail(registroRequestDTO.email());
        usuarioNovo.setSenha(passwordEncoder.encode(registroRequestDTO.senha()));
        usuarioNovo.setSituacao("ativo");

        // salva o usuario no banco e o retorna
        return usuarioRepository.save(usuarioNovo);
    }

    // metodo para carregar o usuario por username (cnpj)
    @Override
    public UserDetails loadUserByUsername(String cnpj) throws UsernameNotFoundException {
        // usa o repository para encontrar o usuario pelo cnpj
        return usuarioRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário (CNPJ) não encontrado: " + cnpj));
    }
}