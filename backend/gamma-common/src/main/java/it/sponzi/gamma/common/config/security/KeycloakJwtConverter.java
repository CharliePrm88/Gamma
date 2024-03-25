package it.sponzi.gamma.common.config.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@Component
@Profile("!h2-db")
public class KeycloakJwtConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Value("${client.name}")
    private String clientName;

    @Override
    public AbstractAuthenticationToken convert(Jwt source) {
        return new JwtAuthenticationToken(source,
                Stream.concat(new JwtGrantedAuthoritiesConverter().convert(source).stream(),
                        extractResourceRoles(source).stream()).collect(toSet()));
    }

    private Collection<? extends GrantedAuthority> extractResourceRoles(Jwt jwt) {
        var resourceAccess = new HashMap<>(jwt.getClaim("resource_access"));

        var client = (Map<String, List<String>>) resourceAccess.get(clientName);

        List<String> roles = client.get("roles");

        return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.replace("-", "_"))).collect(toSet());
    }
}
