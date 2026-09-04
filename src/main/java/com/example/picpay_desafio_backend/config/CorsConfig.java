package com.example.picpay_desafio_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Libera o acesso do front-end Angular a API.
 *
 * O navegador bloqueia requisicoes entre enderecos diferentes (o Angular roda
 * em localhost:4200 e a API em localhost:8080). Esta classe autoriza essa
 * comunicacao.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
                .allowedHeaders("*");
    }
}
