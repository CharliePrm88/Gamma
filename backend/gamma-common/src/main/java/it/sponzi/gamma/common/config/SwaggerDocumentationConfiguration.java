package it.sponzi.gamma.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Springdoc Swagger configuration for documentation of rest api
 *
 * @author sponzi
 */
@Configuration
@Profile("!h2-db")
public class SwaggerDocumentationConfiguration {

//    @Value("${springdoc.swagger-ui.access-token-uri}")
//    private String tokenUrl;

    @Value("${info.app.description}")
    private String infoApp;

    @Value("${info.app.version}")
    private String versionApp;

//    @Value("${keycloak.auth-server-url}")
//    private String authUrl;

    public static final String OAUTH_NAME = "spring_oauth";

    @Bean
    public OpenAPI api() {
        return new OpenAPI().components(new Components()
//                        .addSecuritySchemes(OAUTH_NAME, securityScheme()))
//                .security(List.of(new SecurityRequirement().addList(OAUTH_NAME))
        ).info(apiInfo());
    }

//    SecurityScheme securityScheme() {
//        return new SecurityScheme().type(SecurityScheme.Type.OAUTH2).in(SecurityScheme.In.HEADER)
//                .description("Oauth2 flow")
//                .flows(new OAuthFlows().clientCredentials(new OAuthFlow().authorizationUrl(authUrl)
//                        .refreshUrl(tokenUrl)
//                        .tokenUrl(tokenUrl).scopes(new Scopes().addString("openid", "openid"))));
//    }

    Info apiInfo() {
        return new Info().title(infoApp + " REST CRUD operations API in Spring-Boot 3")
                .description(
                        "Sample REST API for centralized documentation using Spring Boot and springcloud swagger 3 ")
                .termsOfService("").version(versionApp).contact(buildContact());
    }

    private Contact buildContact() {
        Contact contact = new Contact();
        contact.setName("Support Stefano Ponzi");
        contact.setEmail("iznopste@gmail.com");
        contact.setUrl("https://github.com/CharliePrm88");
        return contact;
    }

}
