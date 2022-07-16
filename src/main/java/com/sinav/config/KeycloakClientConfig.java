package com.sinav.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakClientConfig {
    //@Value("${keycloak.credentials.secret}")
    //private String secretKey;

    @Value("${keycloak.auth-server-url}")
    private String authUr;
    @Value("${keycloak.realm}")
    private String realm;
    @Value("${keycloak.resource}")
    private String clientId;


    @Value("${keycloak_admin_user}")
    private String user;

    @Value("${keycloak_admin_password}")
    private String password;


    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                //.grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .grantType(OAuth2Constants.PASSWORD)
                .serverUrl(authUr)
                .realm(realm)
                .clientId(clientId)
                //.clientSecret(secretKey)
                .username(user)
                .password(password)
                .build();
    }
}
