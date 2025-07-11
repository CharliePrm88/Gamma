package it.sponzi.gamma.signer;

import it.sponzi.gamma.common.config.SwaggerDocumentationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@ComponentScan(basePackages = {"it.sponzi.gamma.signer.service", "it.sponzi.gamma.signer.controller", "it.sponzi.gamma.common.config"})
@EntityScan(basePackages = "it.sponzi.gamma.signer.dao")
@EnableJpaRepositories(basePackages = "it.sponzi.gamma.signer.repository")
@Import(SwaggerDocumentationConfiguration.class)
public class SignerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignerApplication.class, args);
	}

}
