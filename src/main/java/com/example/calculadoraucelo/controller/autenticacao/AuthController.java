package com.example.calculadoraucelo.controller.autenticacao;

import com.example.calculadoraucelo.dto.token.JwtTokenResponseDTO;
import com.example.calculadoraucelo.dto.usuario.LoginRequestDTO;
import com.example.calculadoraucelo.dto.usuario.RegistroRequestDTO;
import com.example.calculadoraucelo.model.usuario.Usuario;
import com.example.calculadoraucelo.repository.UsuarioRepository;
import com.example.calculadoraucelo.service.token.TokenService;
import com.example.calculadoraucelo.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    // método post de login
    // /api/auth/login
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequestDTO) {
        // Pega o usuário (cnpj) e senha enviado pelo formulário de login
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequestDTO.cnpj(), loginRequestDTO.senha());

        // Autentica o cnpj e senha usando o authenticationManager
        var auth = this.authenticationManager.authenticate(usernamePassword);

        // pega os detalhes do usuário
        Usuario usuario = (Usuario) auth.getPrincipal();

        // Gera o token
        var token = tokenService.generateToken(usuario);

        // Retorna o status 200 (OK) com o token gerado
        return ResponseEntity.ok(new JwtTokenResponseDTO(token));
    }

    // método post de cadastro
    // api/auth/cadastro
    @PostMapping("/cadastro")
    public ResponseEntity cadastro(@RequestBody RegistroRequestDTO registroRequestDTO) {
        // cria o novo usuário a partir do dto request de cadastro
        Usuario usuario = usuarioService.registrarUsuario(registroRequestDTO);

        // verifica se o usuário foi criado
        if(usuario == null) {
            // retorna status bad request
            return ResponseEntity.badRequest().build();
        }

        // retorna o status 200 (OK) com o usuário
        return ResponseEntity.ok().body(usuario);
    }
}