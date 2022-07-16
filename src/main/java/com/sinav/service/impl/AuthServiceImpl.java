package com.sinav.service.impl;

import com.sinav.dto.UserDto;
import com.sinav.service.async.IAuthService;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private Keycloak keycloak;
    @Value("${keycloak.auth-server-url}")
    private String authUr;
    @Value("${keycloak.realm}")
    private String realm;
    @Value("${keycloak.resource}")
    private String clientId;

    public Map<String, String> authToken(UserDto dto) {
        Map<String, String> token = new HashMap<>();
        keycloak = KeycloakBuilder.builder().serverUrl(authUr).grantType(OAuth2Constants.PASSWORD).realm(realm)
                .clientId(clientId).username(dto.getUsername()).password(dto.getPassword()).build();
        AccessTokenResponse response = keycloak.tokenManager().getAccessToken();
        token.put("type", response.getTokenType());
        token.put("access", response.getToken());
        log.info("Generated Token: " + dto.getUsername());
        return token;
    }

    //TODO
    public void authUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        KeycloakPrincipal principal = (KeycloakPrincipal) auth.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();
        String type = accessToken.getType();
        String tokenHash = session.getTokenString();
        String username = accessToken.getPreferredUsername();
        String userId = accessToken.getSessionId();
        String emailID = accessToken.getEmail();
        String lastname = accessToken.getFamilyName();
        String firstname = accessToken.getGivenName();
        String realmName = accessToken.getIssuer();
        AccessToken.Access realmAccess = accessToken.getRealmAccess();
        //System.out.println(type);
        //System.out.println(tokenHash);
        System.out.println("userId: " + userId);
        System.out.println("Username: " + username);
        System.out.println("Email: " + emailID);
        System.out.println("Name: " + firstname);
        System.out.println("Surname: " + lastname);
        System.out.println("Realm: " + realmName);
        System.out.println("Roles: " + realmAccess.getRoles());

    }


}
