package com.sinav.service.async;

import com.sinav.dto.UserDto;
import org.keycloak.representations.idm.UserRepresentation;

import javax.ws.rs.core.Response;
import java.util.List;

public interface IKeycloakUserService {
    public List<UserRepresentation> findAllUser();

    public List<UserRepresentation> findByUsername(String username);

    public UserRepresentation findByUserId(String id);

    public void createUser(UserDto dto);

    public Response deleteUser(String userId);

    public void userAddGroup(String userId, String groupId);

    public void userLeavGroup(String userId, String groupId);

    public void userAddRol(String userId, String rolAdi);

    public void userDeleteRol(String userId, String rolAdi);
}
