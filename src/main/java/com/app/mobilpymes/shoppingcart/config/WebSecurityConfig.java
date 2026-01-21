package com.app.mobilpymes.shoppingcart.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@EnableWebSecurity
public
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected
    void configure (HttpSecurity http) throws Exception {
        http
                .cors().and()                 // habilitar CORS si usas desde otro origen
                .csrf().disable()             // deshabilita CSRF para APIs REST (solo si es apropiado)
                .authorizeRequests()
                .antMatchers("/api/customer/create").permitAll() // permitir creación pública
                .antMatchers("/api/customer/**").permitAll() // o ajustar según necesidad
                .anyRequest().permitAll();
                     // o eliminar / cambiar según esquema de auth

        // permitir frames para H2 console si la usas
        http.headers().frameOptions().sameOrigin();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource ( ) {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList(
                "http://localhost:3000",
                "https://switch-architecture-hoia.vercel.app/",
                "https://azure-app-shopping-cart-reload-225fb76523b0.herokuapp.com",
                "https://pro-bank-five.vercel.app/",
                "https://mobilpymes.cl",
                "http://www.mobilpymes.cl"
        ));
        config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
        config.setAllowedHeaders(Arrays.asList("Authorization","Content-Type","X-Requested-With"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}

