package com.example.calculadoraucelo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // habilita o CORS
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                // desabilita o CSRF
                .csrf(csrf -> csrf.disable())

                // define as regras de autorização
                .authorizeHttpRequests(auth -> auth
                        // permite acesso total (sem autenticação) a todos os endpoints em /api/calculos/**
                        .requestMatchers("/api/calculos/**").permitAll()
                        // qualquer outra requisição (ex: /admin/**) precisaria de autenticação
                        .anyRequest().authenticated()
                );
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // define a origem permitida (angular)
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));

        // define os métodos permitidos
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // define os headers permitidos
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "x-auth-token"));

        // permite credenciais (se usar cookies ou sessions)
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // aplica a configuração a todas as rotas
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}