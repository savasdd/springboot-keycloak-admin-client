package com.sinav.service.async;

import com.sinav.dto.RolDto;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface IKeycloakRolService {
    public void createRol(RolDto model) throws Exception;

    public RoleRepresentation findRolByName(String rolAdi);

    public void deleteRol(String rolAdi);

    public List<RoleRepresentation> findAllRole();

    public List<UserRepresentation> usersOfRole(String rolAdi);
}
