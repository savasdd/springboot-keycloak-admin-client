package com.sinav.service.impl;

import com.sinav.dto.UserDto;
import com.sinav.service.async.IKeycloakUserService;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class KeycloakUserServiceImpl implements IKeycloakUserService {
    @Autowired
    private Keycloak keycloak;
    @Value("${keycloak.realm}")
    private String realm;

    public List<UserRepresentation> findAllUser() {
        log.info("User FindAll");
        return keycloak.realm(realm).users().list();
    }

    //TODO
    public List<UserRepresentation> findByUsername(String username) {
        log.info("User findByUsername: " + username);
        return keycloak.realm(realm).users().search(username);
    }

    public UserRepresentation findByUserId(String id) {
        log.info("User findById: " + id);
        return keycloak.realm(realm).users().get(id).toRepresentation();
    }

    public void createUser(UserDto dto) {
        UserRepresentation user = prepareUser(dto.getUsername(), preparePassword(dto.getPassword()));
        log.info("User Created: " + user.getUsername());
        keycloak.realm(realm).users().create(user);
    }

    public Response deleteUser(String userId) {
        log.info("User Deleted: " + userId);
        return keycloak.realm(realm).users().delete(userId);
    }

    public void userAddGroup(String userId, String groupId) {
        log.info("User UserToGroup: " + groupId);
        keycloak.realm(realm).users().get(userId).joinGroup(groupId);
    }

    public void userLeavGroup(String userId, String groupId) {
        log.info("User UserLeavGroup: " + groupId);
        keycloak.realm(realm).users().get(userId).leaveGroup(groupId);
    }

    public void userAddRol(String userId, String rolAdi) {
        log.info("User UserAddRol: " + rolAdi);
        RoleRepresentation rol = keycloak.realm(realm).roles().get(rolAdi).toRepresentation();
        keycloak.realm(realm).users().get(userId).roles().realmLevel().add(Arrays.asList(rol));
    }

    public void userDeleteRol(String userId, String rolAdi) {
        log.info("User UserDeleteRol: " + rolAdi);
        RoleRepresentation rol = keycloak.realm(realm).roles().get(rolAdi).toRepresentation();
        keycloak.realm(realm).users().get(userId).roles().realmLevel().remove(Arrays.asList(rol));
    }

    private CredentialRepresentation preparePassword(String password) {
        CredentialRepresentation cr = new CredentialRepresentation();
        cr.setTemporary(false);
        cr.setType(CredentialRepresentation.PASSWORD);
        cr.setValue(password);
        return cr;
    }

    private UserRepresentation prepareUser(String username, CredentialRepresentation cr) {
        UserRepresentation ur = new UserRepresentation();
        ur.setUsername(username);
        ur.setCredentials(Arrays.asList(cr));
        ur.setEnabled(true);
        return ur;
    }

}
