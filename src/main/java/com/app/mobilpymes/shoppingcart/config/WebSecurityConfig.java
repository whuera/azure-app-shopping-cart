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
                .anyRequest().authenticated()
                .and()
                .httpBasic();                 // o eliminar / cambiar según esquema de auth

        // permitir frames para H2 console si la usas
        http.headers().frameOptions().sameOrigin();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource ( ) {
        CorsConfiguration configuration = new CorsConfiguration ( );
        //configuration.setAllowedOrigins ( Arrays.asList ( "https://azure-app-shopping-cart.azurewebsites.net/" ) );
        configuration.setAllowedOrigins ( Arrays.asList ( "http://localhost:4200/" ) );
        configuration.setAllowedMethods ( Arrays.asList ( "GET", "POST" ) );
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource ( );
        source.registerCorsConfiguration ( "/**", configuration );
        return source;
    }
}

