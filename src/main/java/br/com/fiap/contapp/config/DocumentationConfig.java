package br.com.fiap.contapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class DocumentationConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("ContApp API")
                    .description("Uma API para o sistema de contador de calorias.")
                    .summary("Essa api server para controle de alimentacao e exercicios de um usuario")
                    .version("V1")
                    .contact(new Contact()
                        .name("Bruna Gabriela")
                        .email("rm96283@fiap.com")
                    )
                    .license(new License()
                        .name("MIT Open Soucer")
                        .url("http://contapp.com/licenca")
                    )
                )
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}
