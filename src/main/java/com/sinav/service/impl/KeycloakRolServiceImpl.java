package com.sinav.service.impl;

import com.sinav.dto.RolDto;
import com.sinav.service.async.IKeycloakRolService;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class KeycloakRolServiceImpl implements IKeycloakRolService {
    @Autowired
    private Keycloak keycloak;
    @Value("${keycloak.realm}")
    private String realm;

    public void createRol(RolDto model) throws Exception {
        if (model.getName() == null)
            throw new Exception("Rol Adı Zorunlu!");
        RoleRepresentation dto = new RoleRepresentation();
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());
        keycloak.realm(realm).roles().create(dto);
        log.info("Rol Created: " + model.getName());
    }

    public RoleRepresentation findRolByName(String rolAdi) {
        log.info("FindRolByName");
        return keycloak.realm(realm).roles().get(rolAdi).toRepresentation();
    }

    public void deleteRol(String rolAdi) {
        log.info("Rol Deleted: " + rolAdi);
        keycloak.realm(realm).roles().deleteRole(rolAdi);
    }

    public List<RoleRepresentation> findAllRole() {
        log.info("FindAllRols");
        return keycloak.realm(realm).roles().list();
    }

    public List<UserRepresentation> usersOfRole(String rolAdi) {
        List<UserRepresentation> list = keycloak.realm(realm).roles().get(rolAdi).getRoleUserMembers().stream().filter(val -> Objects.nonNull(val.getFirstName())).toList();
        log.info("UsersOfRole: " + list.size());
        return list;
    }

}
