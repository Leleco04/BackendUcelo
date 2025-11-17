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

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registrarUsuario(RegistroRequestDTO registroRequestDTO) {
        // Antes de fazer o cadastro, verifica se o cnpj já está registrado
        if(usuarioRepository.existsByCnpj(registroRequestDTO.cnpj())) {{
            throw new RuntimeException("Erro: CNPJ já existente.");
        }}

        Usuario usuarioNovo = new Usuario();

        usuarioNovo.setCnpj(registroRequestDTO.cnpj());
        usuarioNovo.setNomeEmpresa(registroRequestDTO.nomeEmpresa());
        usuarioNovo.setEmail(registroRequestDTO.email());
        usuarioNovo.setSenha(passwordEncoder.encode(registroRequestDTO.senha()));
        usuarioNovo.setSituacao("ativo");

        return usuarioRepository.save(usuarioNovo);
    }

    @Override
    public UserDetails loadUserByUsername(String cnpj) throws UsernameNotFoundException {
        return usuarioRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário (CNPJ) não encontrado: " + cnpj));
    }
}