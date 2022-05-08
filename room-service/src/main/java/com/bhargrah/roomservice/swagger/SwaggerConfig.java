package com.bhargrah.roomservice.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SwaggerConfig {
  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .components(
            new Components()
                .addSecuritySchemes(
                    "basicScheme",
                    new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
        .info(
            new Info()
                .title("Room Management API")
                .version("v1.0")
                    .termsOfService("Public domain")
                    .contact(new Contact().name("Rahul Bhargava"))
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
  }
}
