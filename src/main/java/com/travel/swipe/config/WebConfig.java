package com.travel.swipe.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Autorise toutes les routes
                .allowedOrigins("http://localhost:4200")  // Remplace par l'URL de ton frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Méthodes autorisées
                .allowedHeaders("*")  // Autoriser tous les en-têtes
                .allowCredentials(true);  // Si tu utilises les cookies ou les sessions
    }
}