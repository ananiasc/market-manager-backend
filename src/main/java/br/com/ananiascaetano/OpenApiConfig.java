package br.com.ananiascaetano;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	@Value("${api.version}")
    private String apiVersion;
	
	@Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("Market Backend")
                .version(apiVersion)
                .description("Backend de um sistema E-commerce baseado em minhas experiências dentro do ramo"));
    }
}
