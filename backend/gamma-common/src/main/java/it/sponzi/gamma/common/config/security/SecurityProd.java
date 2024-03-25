package it.sponzi.gamma.common.config.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * SecurityConfigurer is to configure ResourceServer and HTTP Security.
 * <p>
 * Please make sure you check HTTP Security configuration and change is as per
 * your needs.
 * </p>
 * <p>
 * Note: Use {@link CorsProperties} to configure required CORS configuration
 * and enable or disable security of application.
 */
@Configuration
@EnableWebFluxSecurity
@EnableMethodSecurity(prePostEnabled = true)
@Profile({"prod"})
@Import({CorsProperties.class})
public class SecurityProd {

    private final CorsProperties securityProperties;

    /* Using spring constructor injection, @Autowired is implicit */
    public SecurityProd(CorsProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Bean
    public SecurityWebFilterChain filterChain(final ServerHttpSecurity http) throws Exception {
        http.authorizeExchange(httpRequest -> httpRequest.anyExchange().authenticated());
        http.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()));
        http.headers(headers -> headers.frameOptions(ServerHttpSecurity.HeaderSpec.FrameOptionsSpec::disable));
        http.csrf(ServerHttpSecurity.CsrfSpec::disable);
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        if (null != securityProperties.getCorsConfiguration()) {
            source.registerCorsConfiguration(securityProperties.getCors().getPattern(), securityProperties.getCorsConfiguration());
        }
        return source;
    }
}
