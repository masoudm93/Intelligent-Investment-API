package com.masoud.intelligentinvestmentapi.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI investmentApiDocs() {
        return new OpenAPI()
                .info(new Info()
                        .title("Intelligent Investment Allocation API")
                        .description("Simulates rule-based capital allocation using investor profiles")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Masoud Maleki")
                                .email("masoud.maleki993@example.com")
                                .url("https://github.com/your-github"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub Repo")
                        .url("https://github.com/masoudm93/intelligent-investment-api"));
    }
}
