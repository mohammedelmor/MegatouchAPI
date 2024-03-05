package org.megatouch.api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "keycloak")
@Getter
@Setter
public class KeycloakConfigProps {
    private String keySet;
}
