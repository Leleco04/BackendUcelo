package com.example.calculadoraucelo.security;

import com.auth0.jwt.JWT;
import com.example.calculadoraucelo.model.usuario.Usuario;
import com.example.calculadoraucelo.repository.UsuarioRepository;
import com.example.calculadoraucelo.service.token.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);

        if (token != null) {
            // Valida o token e pega o CNPJ
            var cnpj = tokenService.validateToken(token);

            if (cnpj != null && !cnpj.isEmpty()) {

                // --- INÍCIO DA CORREÇÃO ---

                // 2. BUSQUE O OBJETO 'Usuario' (como seu repositório retorna)
                Usuario usuario = usuarioRepository.findByCnpj(cnpj).orElse(null);

                // 3. SE O USUÁRIO EXISTIR, CRIE A AUTENTICAÇÃO
                if (usuario != null) {

                    // Assumindo que sua classe 'Usuario' implementa 'UserDetails',
                    // podemos chamar 'usuario.getAuthorities()'
                    var authentication = new UsernamePasswordAuthenticationToken(
                            usuario, // O 'principal' é o objeto Usuario
                            null,
                            usuario.getAuthorities() // As permissões do 'UserDetails'
                    );

                    // 4. DEFINA A AUTENTICAÇÃO NO CONTEXTO
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

                // --- FIM DA CORREÇÃO ---
            }
        }
        filterChain.doFilter(request, response);
    }

    // Método para recuperar o token
    private String recoverToken(HttpServletRequest request) {
        // Busca e armazena o valor da header no qual o token é passado (Authorization)
        var authHeader = request.getHeader("Authorization");

        // Se não tiver nenhum token, retorna null
        if (authHeader == null) return null;

        return authHeader.replace("Bearer ", "");
    }
}
