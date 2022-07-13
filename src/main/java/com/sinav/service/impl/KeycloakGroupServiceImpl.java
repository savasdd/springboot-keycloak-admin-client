package com.sinav.service.impl;

import com.sinav.dto.GroupDto;
import com.sinav.service.async.IKeycloakGroupService;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class KeycloakGroupServiceImpl implements IKeycloakGroupService {
    @Autowired
    private Keycloak keycloak;
    @Value("${keycloak.realm}")
    private String realm;

    @Override
    public void createGroup(GroupDto model) throws Exception {
        if (model.getName() == null)
            throw new Exception("Grup Adı Zorunlu!");
        GroupRepresentation dto = new GroupRepresentation();
        dto.setName(model.getName());
        keycloak.realm(realm).groups().add(dto);
        log.info("Group Created: " + model.getName());
    }

    @Override
    public GroupRepresentation findGroupByName(String id) {
        log.info("FindGroupById");
        return keycloak.realm(realm).groups().group(id).toRepresentation();
    }

    @Override
    public void deleteGroup(String id) {
        log.info("Group Deleted: " + id);
        keycloak.realm(realm).groups().group(id).remove();
    }

    @Override
    public List<GroupRepresentation> findAllGroup() {
        return keycloak.realm(realm).groups().groups();
    }

    @Override
    public List<UserRepresentation> usersOfGroup(String id) {
        log.info("UsersOfGroup");
        List<UserRepresentation> list = keycloak.realm(realm).groups().group(id).members();
        return list;
    }

    @Override
    public void rolAddGroup(String groupId, String rolAdi) {
        log.info("Group RolAddGroup: " + groupId);
        RoleRepresentation rol = keycloak.realm(realm).roles().get(rolAdi).toRepresentation();
        keycloak.realm(realm).groups().group(groupId).roles().realmLevel().add(Arrays.asList(rol));
    }

    @Override
    public List<RoleRepresentation> rolsOfGroup(String id) {
        log.info("RolsOfGroup");
        List<RoleRepresentation> list = keycloak.realm(realm).groups().group(id).roles().realmLevel().listAll();
        return list;
    }


}
