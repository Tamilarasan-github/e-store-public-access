package com.tamilcreations.estorepublicaccess.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
     //   config.addAllowedOrigin("*"); // Add your frontend origin //The problem is this cannot be used when this is true config.setAllowCredentials(true);
     
        config.addAllowedOriginPattern("*"); // Use allowedOriginPatterns to allow credentials and wildcard origins
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);
        source.registerCorsConfiguration("/graphql/**", config);

        return new CorsFilter(source);
    }
}

