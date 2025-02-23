package com.perpustakaan.beperpustakaan.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI myOpenAPI(){
        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Server url in local environment");

        Contact contact = new Contact();
        contact.setEmail("anwarjuniansyah5@gmail.com");
        contact.setName("http://www.test.com");

        License license = new License().name("MIT License").url("https://test.com");

        Info info = new Info().title("Tiktok Project").version("1.0").contact(contact).description("This API for Applicatioin").termsOfService("http://www.test.com/terms").license(license);
        SecurityScheme securityScheme = new SecurityScheme().type(SecurityScheme.Type.HTTP).bearerFormat("JWT").scheme("bearer");

        return new OpenAPI().components(new Components().addSecuritySchemes("Bearer Authentication", securityScheme)).info(info).servers(List.of(localServer));    }
}