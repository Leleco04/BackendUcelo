package com.example.calculadoraucelo.service.usuario;

import com.example.calculadoraucelo.dto.usuario.RegistroUsuarioRequestDTO;
import com.example.calculadoraucelo.model.usuario.Usuario;
import com.example.calculadoraucelo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Usuario registrarUsuario(RegistroUsuarioRequestDTO registroUsuarioRequestDTO) {

        Usuario usuarioNovo = new Usuario();

        return usuarioRepository.save(usuarioNovo);
    }

}
