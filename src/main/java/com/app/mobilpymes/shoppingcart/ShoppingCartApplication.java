package com.app.mobilpymes.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaAuditing
public
class ShoppingCartApplication {

    public static
    void main (String[] args) {
        SpringApplication.run ( ShoppingCartApplication.class, args );
    }

    @Bean
    public
    WebMvcConfigurer corsConfigurer ( ) {
        return new WebMvcConfigurer ( ) {
            @Override
            public
            void addCorsMappings (CorsRegistry registry) {
                registry.addMapping ( "/**" ).allowedOrigins ( "/**" ).allowedMethods ( "*" ).allowedHeaders ( "*" );
            }
        };
    }

}
