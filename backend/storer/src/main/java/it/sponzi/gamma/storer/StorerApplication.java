package it.sponzi.gamma.storer;

import it.sponzi.gamma.common.config.SwaggerDocumentationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@ComponentScan(basePackages = {"it.sponzi.gamma.storer.dao.service", "it.sponzi.gamma.storer.dao.controller"})
@EntityScan(basePackages = "it.sponzi.gamma.storer.dao")
@EnableR2dbcRepositories(basePackages = "it.sponzi.gamma.storer.repository")
@Import(SwaggerDocumentationConfiguration.class)
public class StorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorerApplication.class, args);
	}

}
