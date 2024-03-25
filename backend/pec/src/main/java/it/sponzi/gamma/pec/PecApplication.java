package it.sponzi.gamma.pec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@ComponentScan(basePackages = {"it.sponzi.gamma.pec.service", "it.sponzi.gamma.pec.controller", "it.sponzi.gamma.common.config"})
@EntityScan(basePackages = "it.sponzi.gamma.pec.dao")
@EnableJpaRepositories(basePackages = "it.sponzi.gamma.pec.repository")
public class PecApplication {

	public static void main(String[] args) {
		SpringApplication.run(PecApplication.class, args);
	}

}
