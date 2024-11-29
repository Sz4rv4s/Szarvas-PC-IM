package hu.szarvas.gateway_service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class KeycloakRealmRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");

        Map<String, Map<String, List<String>>> resourceAccess =
                (Map<String, Map<String, List<String>>>) jwt.getClaims().get("resource_access");

        if (realmAccess == null || realmAccess.isEmpty()) {
            log.info("realmAccess is NULL");
            return List.of();
        } else {
            log.info("realmAccess is NOT NULL");
        }

        if (resourceAccess == null || resourceAccess.isEmpty()) {
            log.info("resourceAccess is NULL");
            return List.of();
        } else {
            log.info("resourceAccess is NOT NULL");
        }


        List<String> roles = (List<String>) realmAccess.get("roles");

        if (roles == null || roles.isEmpty()) {
            log.info("roles is NULL");
            return List.of();
        }

        log.info("roles Is NOT NULL");
        log.info("roles : {}", roles);
        return roles.stream()
                .map(roleName -> "ROLE_" + roleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}