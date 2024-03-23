package it.sponzi.gamma.pec;

import it.sponzi.gamma.common.config.SwaggerDocumentationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@ComponentScan(basePackages = {"it.sponzi.gamma.pec.service", "it.sponzi.gamma.pec.controller"})
@EntityScan(basePackages = "it.sponzi.gamma.pec.dao")
@EnableR2dbcRepositories(basePackages = "it.sponzi.gamma.pec.repository")
@Import(SwaggerDocumentationConfiguration.class)
public class PecApplication {

	public static void main(String[] args) {
		SpringApplication.run(PecApplication.class, args);
	}

}
