package com.sinav.service.async;

import com.sinav.dto.GroupDto;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface IKeycloakGroupService {
    public void createGroup(GroupDto model) throws Exception;

    public GroupRepresentation findGroupByName(String id);

    public void deleteGroup(String id);

    public List<GroupRepresentation> findAllGroup();

    public List<UserRepresentation> usersOfGroup(String id);

    public void rolAddGroup(String groupId, String rolAdi);

    public List<RoleRepresentation> rolsOfGroup(String id);
}
